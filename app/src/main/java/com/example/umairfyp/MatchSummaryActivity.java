package com.example.umairfyp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umairfyp.model.Batsman_data.Scorecard;
import com.example.umairfyp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;


public class MatchSummaryActivity extends AppCompatActivity {

   // String url = "https://api.cricapi.com/v1/match_scorecard?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f&id";
    String apikey = "7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f";
    Scorecard scorecard_model;
    RecyclerView rv1stbat,rv2ndbat,rv1stbowl,rv2ndbowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);


        rv1stbat = findViewById(R.id.rv_1stBat);
        rv1stbat.setLayoutManager(new LinearLayoutManager(this));
        rv2ndbat = findViewById(R.id.rv_2ndBat);
        rv2ndbat.setLayoutManager(new LinearLayoutManager(this));
        rv1stbowl = findViewById(R.id.rv_1stBowl);
        rv1stbowl.setLayoutManager(new LinearLayoutManager(this));
        rv2ndbowl = findViewById(R.id.rv_2ndBowl);
        rv2ndbowl.setLayoutManager(new LinearLayoutManager(this));


        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Players Details");
        //Back button
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String uniqueId = intent.getStringExtra("match_id");

        RetrofitClient.getInstance().getServices().getScorecard(apikey, uniqueId).enqueue(new Callback<Scorecard>() {
            @Override
            public void onResponse(Call<Scorecard> call, retrofit2.Response<Scorecard> response) {
/*
                scorecard_model = response.body();
                if(scorecard_model != null){
                    BatsmanAdapter batsmanAdapter = new BatsmanAdapter (scorecard_model.);
                    rv1stbat.setAdapter(batsmanAdapter);

                }
                if(scorecard_model != null){
                    BatsmanAdapter2 batsmanAdapter2 = new BatsmanAdapter2 (scorecard_model.getBatting());
                    rv2ndbat.setAdapter(batsmanAdapter2);

                }
                if(scorecard_model != null){
                    BowlerAdapter bowlerAdapter = new BowlerAdapter (scorecard_model.getBowling());
                    rv1stbowl.setAdapter(bowlerAdapter);

                }
                if(scorecard_model != null){
                    BowlerAdapter2 bowlerAdapter2 = new BowlerAdapter2 (scorecard_model.getBowling());
                    rv1stbowl.setAdapter(bowlerAdapter2);

                }
*/`
            }

            @Override
            public void onFailure(Call<Scorecard> call, Throwable t) {

            }
        });


    }
}