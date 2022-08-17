package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.umairfyp.databinding.ActivityCommentBinding;
import com.google.firebase.firestore.auth.User;

public class comment_activity extends AppCompatActivity {

    private ActivityCommentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}