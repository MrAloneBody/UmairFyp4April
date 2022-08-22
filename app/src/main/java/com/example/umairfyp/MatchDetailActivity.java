package com.example.umairfyp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umairfyp.Adapters.CommentAdapter;
import com.example.umairfyp.SignIN_UP.SignInActivity;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PrefrenceManager1;
import com.example.umairfyp.databinding.MatchDetailsBinding;
import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.model.Comment_models.CommentMessage;
import com.example.umairfyp.model.Comment_models.User;
import com.example.umairfyp.model.Data;
import com.example.umairfyp.model.Model;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.remote.WatchChange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class MatchDetailActivity extends AppCompatActivity {

    private MatchDetailsBinding binding;
    private User recieverUser;
    private List<CommentMessage> commentMessages;
    private PrefrenceManager1 prefrenceManager1;
    private FirebaseFirestore database;
    private CommentAdapter commentadapter;
    public String match_id;
    ArrayList<Comment> commentArrayList;

    TextView mTeam1Tv, mTeam2Tv, mMatchStatusTv, mScore1Tv, mDateTv,mScore2Tv,mWickets1Tv,mOvers1Tv,mWickets2Tv,mOvers2Tv;
    TextView mScore3Tv,mScore4Tv,mOvers3Tv,mOvers4Tv,mWickets3Tv,mWickets4Tv;
    TextView slash1,slash2,slash3,slash4,sp1,sp2,sp3,sp4,ep1,ep2,ep3,ep4;
    ImageView sendcomment;
    EditText writecomment;
    RecyclerView recyclerView_comment;
    private CommentAdapter1 commentAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_details);

        binding = MatchDetailsBinding.inflate(getLayoutInflater());

        recyclerView_comment = findViewById(R.id.Comments_Recycler_View);
        recyclerView_comment.setHasFixedSize(true);
        recyclerView_comment.setLayoutManager(new LinearLayoutManager(this));
/*
        database = FirebaseFirestore.getInstance();
        commentArrayList = new ArrayList<Comment>();
        commentAdapter1 = new CommentAdapter1(MatchDetailActivity.this, commentArrayList);

        EventChangeListener();

 */
        //Actionbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Match Details");

        //Back button

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        slash1 = findViewById(R.id.Slash1);
        slash2 = findViewById(R.id.Slash2);
        slash3 = findViewById(R.id.Slash3);
        slash4 = findViewById(R.id.Slash4);
        ep1 = findViewById(R.id.EP1);
        ep2 = findViewById(R.id.EP2);
        ep3 = findViewById(R.id.EP3);
        ep4 = findViewById(R.id.EP4);
        sp1 = findViewById(R.id.SP1);
        sp2 = findViewById(R.id.SP2);
        sp3 = findViewById(R.id.SP3);
        sp4 = findViewById(R.id.SP4);


        //get data from intent (Onclick from previous activity)
        Intent intent = getIntent();
        match_id= intent.getStringExtra("match_id");
        String date = intent.getStringExtra("date");
        String Team1= intent.getStringExtra("Team1");
        String Score1 = intent.getStringExtra("Score1");
        String Score3 = intent.getStringExtra("Score3");
        String Team2 = intent.getStringExtra("Team2");
        String Score2 = intent.getStringExtra("Score2");
        String Score4 = intent.getStringExtra("Score4");
        String MatchStatus= intent.getStringExtra("MatchStatus");
        String Wickets1 = intent.getStringExtra("Wickets1");
        String Wickets2 = intent.getStringExtra("Wickets2");
        String Overs1 = intent.getStringExtra("Overs1");
        String Overs2 = intent.getStringExtra("Overs2");
        String Wickets3 = intent.getStringExtra("Wickets3");
        String Wickets4 = intent.getStringExtra("Wickets4");
        String Overs3 = intent.getStringExtra("Overs3");
        String Overs4 = intent.getStringExtra("Overs4");
        int inning_size = intent.getIntExtra("innings_size",0);

        if (inning_size < 4) {
            slash4.setVisibility(View.GONE);
            ep4.setVisibility(View.GONE);
            sp4.setVisibility(View.GONE);
        }

        if (inning_size < 3) {
            slash3.setVisibility(View.GONE);
            ep3.setVisibility(View.GONE);
            sp3.setVisibility(View.GONE);
        }

        if (inning_size < 2) {
            slash2.setVisibility(View.GONE);
            ep2.setVisibility(View.GONE);
            sp2.setVisibility(View.GONE);
        }

        if (inning_size < 1) {
            slash1.setVisibility(View.GONE);
            ep1.setVisibility(View.GONE);
            sp1.setVisibility(View.GONE);
        }



        mTeam1Tv = findViewById(R.id.team1tv);
        mTeam2Tv = findViewById(R.id.team2tv);
        mMatchStatusTv = findViewById(R.id.matchstatustv);
        mScore1Tv = findViewById(R.id.score1Tv);
        mScore2Tv = findViewById(R.id.score2Tv);
        mDateTv = findViewById(R.id.datetv);
        mWickets1Tv = findViewById(R.id.wicket1tv);
        mWickets2Tv = findViewById(R.id.wicket2tv);
        mOvers1Tv = findViewById(R.id.over1tv);
        mOvers2Tv = findViewById(R.id.over2tv);
        mScore3Tv = findViewById(R.id.score3Tv);
        mScore4Tv = findViewById(R.id.score4Tv);
        mWickets3Tv = findViewById(R.id.wicket3tv);
        mWickets4Tv = findViewById(R.id.wicket4tv);
        mOvers3Tv = findViewById(R.id.over3tv);
        mOvers4Tv = findViewById(R.id.over4tv);
        sendcomment = findViewById(R.id.send_comment);
        writecomment =findViewById(R.id.writeComment);



        mDateTv.setText(date);
        mTeam1Tv.setText(Team1);
        mScore1Tv.setText(Score1);
        mScore3Tv.setText(Score3);
        mTeam2Tv.setText(Team2);
        mScore2Tv.setText(Score2);
        mScore4Tv.setText(Score4);
        mMatchStatusTv.setText(MatchStatus);
        mWickets1Tv.setText(Wickets1);
        mWickets2Tv.setText(Wickets2);
        mWickets3Tv.setText(Wickets3);
        mWickets4Tv.setText(Wickets4);
        mOvers1Tv.setText(Overs1);
        mOvers2Tv.setText(Overs2);
        mOvers3Tv.setText(Overs3);
        mOvers4Tv.setText(Overs4);


        loadRecieverDetails();

        sendcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        init();
        listenerMessages();

    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();//goto prev activity


        return super.onSupportNavigateUp();
    }



    private void init(){

        prefrenceManager1 = new PrefrenceManager1(getApplicationContext());
        commentMessages = new ArrayList<>();
        commentadapter = new CommentAdapter(commentMessages,prefrenceManager1.getString(Constants.KEY_USER_ID));
        binding.CommentsRecyclerView.setAdapter(commentadapter);
        database =  FirebaseFirestore.getInstance();
    }


    private void sendMessage() {
        if (writecomment.getText().toString().isEmpty()) {
              Toast.makeText(this, "Enter Comment", Toast.LENGTH_SHORT).show();

        }else{
            HashMap<String, Object> message = new HashMap<>();
            message.put(Constants.KEY_SENDER_ID, prefrenceManager1.getString(Constants.KEY_USER_ID));
            message.put(Constants.KEY_NAME,prefrenceManager1.getString(Constants.KEY_NAME));
            message.put(Constants.KEY_EMAIL,prefrenceManager1.getString(Constants.KEY_EMAIL));
            message.put(Constants.KEY_RECIEVER_ID, match_id);
            message.put(Constants.KEY_MESSAGE, writecomment.getText().toString());
            database.collection(Constants.KEY_COLLECTION_COMMENT).add(message);
            Toast.makeText(this, "Comment Submitted", Toast.LENGTH_SHORT).show();
            writecomment.setText("");
        }
    }

    private void listenerMessages(){
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
      if( error != null){
          return;
      }
      if(value != null){
          int count = commentMessages.size();
          for(DocumentChange documentChange : value.getDocumentChanges()){
              if(documentChange.getType() == DocumentChange.Type.ADDED){

                  CommentMessage commentMessage = new CommentMessage();
                  CommentMessage.senderId = documentChange.getDocument().getString(Constants.KEY_SENDER_ID);
                  CommentMessage.recieverId = documentChange.getDocument().getString(match_id);
                  CommentMessage.message = documentChange.getDocument().getString(Constants.KEY_MESSAGE);
                  commentMessages.add(commentMessage);
              }
          }
          binding.CommentsRecyclerView.setVisibility(View.VISIBLE);
      }
    };
    public void loadRecieverDetails(){

             recieverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER_ID);
    }



    private void EventChangeListener() {

        database.collection("comment");


    }

}