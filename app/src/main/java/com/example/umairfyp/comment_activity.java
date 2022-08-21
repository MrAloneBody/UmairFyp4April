package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListAdapter;

import com.example.umairfyp.Adapters.CommentAdapter;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PrefrenceManager1;
import com.example.umairfyp.databinding.MatchDetailsBinding;
import com.example.umairfyp.model.Comment_models.CommentMessage;
import com.example.umairfyp.model.Comment_models.User;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class comment_activity extends AppCompatActivity {

    private MatchDetailsBinding binding;
    private User recieverUser;
    private List<CommentMessage> commentMessages;
  //  private PREFRENCEmanager prefrencEmanager;
    private PrefrenceManager1 prefrenceManager1;
    private FirebaseFirestore database;
    private CommentAdapter commentadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MatchDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadRecieverDetails();
        init();
    }

    private void init(){

        prefrenceManager1 = new PrefrenceManager1(getApplicationContext());
        commentMessages = new ArrayList<>();
        commentadapter = new CommentAdapter(commentMessages,prefrenceManager1.getString(Constants.KEY_USER_ID));
    //    binding.CommentsRecyclerView.setAdapter((RecyclerView.Adapter) commentadapter);
        database =  FirebaseFirestore.getInstance();
    }


    private void sendMessage(){
        HashMap<String , Object> message = new HashMap<>();
        message.put(Constants.KEY_SENDER_ID,prefrenceManager1.getString(Constants.KEY_USER_ID));
        message.put(Constants.KEY_RECIEVER_ID, recieverUser.id);
  //      message.put(Constants.KEY_MESSAGE,binding.);
    }

    public void loadRecieverDetails(){
        recieverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER_ID);
    }
}