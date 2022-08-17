package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;

import com.example.umairfyp.Adapters.Comment_Adapter;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PREFRENCEmanager;
import com.example.umairfyp.databinding.MatchDetailsBinding;
import com.example.umairfyp.model.Comment_models.CommentMessage;
import com.example.umairfyp.model.Comment_models.User;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class comment_activity extends AppCompatActivity {

    private MatchDetailsBinding binding;
    private User recieverUser;
    private List<CommentMessage> commentMessages;
    private PREFRENCEmanager prefrencEmanager;
    private FirebaseFirestore database;
    private Comment_Adapter comment_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MatchDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadRecieverDetails();
        init();
    }

    private void init(){

        prefrencEmanager = new PREFRENCEmanager(getApplicationContext());
        commentMessages = new ArrayList<>();
        comment_adapter = new Comment_Adapter(commentMessages,prefrencEmanager.getString(Constants.KEY_USER_ID));
        binding.CommentsRecyclerView.setAdapter((ListAdapter) comment_adapter);
        database =  FirebaseFirestore.getInstance();
    }


    public void loadRecieverDetails(){
        recieverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER_ID);
    }
}