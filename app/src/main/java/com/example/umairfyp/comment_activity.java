package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.databinding.ActivityCommentBinding;
import com.example.umairfyp.model.Comment_models.User;

public class comment_activity extends AppCompatActivity {

    private ActivityCommentBinding binding;
    private User recieverUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void loadRecieverDetails(){
        recieverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER_ID);
    }
}