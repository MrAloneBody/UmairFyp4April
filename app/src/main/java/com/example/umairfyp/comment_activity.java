package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;

import com.example.umairfyp.Adapters.CommentAdapter;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PrefrenceManager1;
import com.example.umairfyp.databinding.MatchDetailsBinding;
import com.example.umairfyp.model.Comment_models.CommentMessage;
import com.example.umairfyp.model.Comment_models.User;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class comment_activity extends AppCompatActivity {

    private MatchDetailsBinding binding;
    private User recieverUser;
    private List<CommentMessage> commentMessages;
    private PrefrenceManager1 prefrenceManager1;
    private MatchDetailActivity matchDetailActivity;
    private FirebaseFirestore database;
    private CommentAdapter commentadapter;
    private String match_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MatchDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        match_id=matchDetailActivity.match_id;

    //    setListener();
        loadRecieverDetails();
      //  init();
      //  listenMessages();
    }

    private void init(){

        prefrenceManager1 = new PrefrenceManager1(getApplicationContext());
        commentMessages = new ArrayList<>();

        commentadapter = new CommentAdapter(
                commentMessages,prefrenceManager1.getString(Constants.KEY_USER_ID)
        );
        // commentadapter = new CommentAdapter(commentMessages,prefrenceManager1.getString(Constants.KEY_USER_ID));
        binding.CommentsRecyclerView.setAdapter(commentadapter);
        database =  FirebaseFirestore.getInstance();
    }
    /*

        private void listenMessages(){
            database.collection(Constants.KEY_COLLECTION_COMMENT)
                    .whereEqualTo(Constants.KEY_SENDER_ID,prefrenceManager1.getString(Constants.KEY_USER_ID))
                    .whereEqualTo(Constants.KEY_RECIEVER_ID,match_id)
                    .addSnapshotListener(eventListener);
            database.collection(Constants.KEY_COLLECTION_COMMENT)
                    .whereEqualTo(Constants.KEY_SENDER_ID,match_id)
                    .whereEqualTo(Constants.KEY_RECIEVER_ID,prefrenceManager1.getString(Constants.KEY_USER_ID))
                    .addSnapshotListener(eventListener);
        }

        private final EventListener<QuerySnapshot> eventListener = (value,error) ->{
          if(error != null ){

              return;
          }
          if(value != null ){
              int count = commentMessages.size();
              for(DocumentChange documentChange : value.getDocumentChanges()){
                  if(documentChange.getType()== DocumentChange.Type.ADDED){

                      CommentMessage commentMessage = new CommentMessage();
                      commentMessage.senderId = documentChange.getDocument().getString(Constants.KEY_SENDER_ID);
                      commentMessage.recieverId = documentChange.getDocument().getString(match_id);
                      commentMessage.message = documentChange.getDocument().getString(Constants.KEY_MESSAGE);
                      commentMessage.dateTime = documentChange.getDocument().getString(Constants.KEY_TIMESTAMP);
                      commentMessages.add(commentMessage);

                  }
              }
         //     Collections.sort(commentMessages,(obj1,obj2)-> obj1.date);
              if(count==0){
                  commentadapter.notifyDataSetChanged();
              }else{
                  commentadapter.notifyItemRangeInserted(commentMessages.size(), commentMessages.size());
                  binding.CommentsRecyclerView.smoothScrollToPosition(commentMessages.size()-1);
              }
              binding.CommentsRecyclerView.setVisibility(View.VISIBLE);
          }

        };

        private void sendMessage(){
            HashMap<String , Object> message = new HashMap<>();
            message.put(Constants.KEY_SENDER_ID,prefrenceManager1.getString(Constants.KEY_USER_ID));
            message.put(Constants.KEY_RECIEVER_ID, match_id);
            message.put(Constants.KEY_TIMESTAMP , new Date());
            database.collection(Constants.KEY_COLLECTION_COMMENT).add(message);
            binding.writeComment.setText("");
      //      message.put(Constants.KEY_MESSAGE,binding.);
        }


     */
    public void loadRecieverDetails(){
        recieverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER_ID);
    }

   // public void setListener(){binding.sendComment.setOnClickListener(v -> sendMessage());}

}