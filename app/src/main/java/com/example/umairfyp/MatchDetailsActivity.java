package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.umairfyp.Adapters.CommentAdapter;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PrefrenceManager1;
import com.example.umairfyp.databinding.ActivityMatchDetailsBinding;
import com.example.umairfyp.model.Comment;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MatchDetailsActivity extends AppCompatActivity {

    private ActivityMatchDetailsBinding binding;
    private CommentAdapter commentsAdapter;
    private FirebaseFirestore database;
    public String matchId;
    private PrefrenceManager1 preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMatchDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        initOnClicks();
        getData();
    }

    private void initOnClicks() {
        binding.sendComment.setOnClickListener(v -> {
            if (binding.writeComment.getText().toString().isEmpty()) {
                Toast.makeText(MatchDetailsActivity.this, "Enter Comment", Toast.LENGTH_SHORT).show();

            } else {
                Comment comment = new Comment("",
                        preferenceManager.getString(Constants.KEY_EMAIL),
                        binding.writeComment.getText().toString(),
                        preferenceManager.getString(Constants.KEY_NAME),
                        matchId,
                        preferenceManager.getString(Constants.KEY_USER_ID),
                        Timestamp.now());
                database.collection(Constants.KEY_COLLECTION_COMMENT).add(comment);
                Toast.makeText(MatchDetailsActivity.this, "Comment Submitted", Toast.LENGTH_SHORT).show();
                binding.writeComment.setText("");
            }
        });
    }

    private void init() {
        Intent intent = getIntent();
        matchId = intent.getStringExtra("match_id");
        database = FirebaseFirestore.getInstance();
        preferenceManager = new PrefrenceManager1(this);

        // init adapters
        binding.rvComments.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        // init details
        initDetails();
    }

    private void initDetails() {
        Intent intent = getIntent();
        binding.datetv.setText(intent.getStringExtra("date"));
        binding.team1tv.setText(intent.getStringExtra("Team1"));
        binding.score1Tv.setText(intent.getStringExtra("Score1"));
        binding.score3Tv.setText(intent.getStringExtra("Score3"));
        binding.team2tv.setText(intent.getStringExtra("Team2"));
        binding.score2Tv.setText(intent.getStringExtra("Score2"));
        binding.score4Tv.setText(intent.getStringExtra("Score4"));
        binding.matchstatustv.setText(intent.getStringExtra("MatchStatus"));
        binding.wicket1tv.setText(intent.getStringExtra("Wickets1"));
        binding.wicket2tv.setText(intent.getStringExtra("Wickets2"));
        binding.wicket3tv.setText(intent.getStringExtra("Wickets3"));
        binding.wicket4tv.setText(intent.getStringExtra("Wickets4"));
        binding.over1tv.setText(intent.getStringExtra("Overs1"));
        binding.over2tv.setText(intent.getStringExtra("Overs2"));
        binding.over3tv.setText(intent.getStringExtra("Overs3"));
        binding.over4tv.setText(intent.getStringExtra("Overs4"));

        int inning_size = intent.getIntExtra("innings_size", 0);

        if (inning_size < 4) {
            binding.Slash4.setVisibility(View.GONE);
            binding.EP4.setVisibility(View.GONE);
            binding.SP4.setVisibility(View.GONE);
        }

        if (inning_size < 3) {
            binding.Slash3.setVisibility(View.GONE);
            binding.EP3.setVisibility(View.GONE);
            binding.SP3.setVisibility(View.GONE);
        }

        if (inning_size < 2) {
            binding.Slash2.setVisibility(View.GONE);
            binding.EP2.setVisibility(View.GONE);
            binding.SP2.setVisibility(View.GONE);
        }

        if (inning_size < 1) {
            binding.Slash1.setVisibility(View.GONE);
            binding.EP1.setVisibility(View.GONE);
            binding.SP1.setVisibility(View.GONE);
        }
    }

    private void getData() {
        database.collection(Constants.KEY_COLLECTION_COMMENT)
                .orderBy("timestamp", Query.Direction.ASCENDING)
                .whereEqualTo("match_id", matchId)
                .addSnapshotListener((value, e) -> {
                    if (e != null) {
                        Log.w("debugging", "Listen failed.", e);
                        return;
                    }

                    List<Comment> comments = new ArrayList<>();
                    if (value != null) {
                        for (QueryDocumentSnapshot doc : value) {
                            comments.add(doc.toObject(Comment.class));
                        }
                    }
                    Log.d("debugging", "Data: " + comments);
                    commentsAdapter = new CommentAdapter(comments);
                    binding.rvComments.setAdapter(commentsAdapter);
                });
    }
}