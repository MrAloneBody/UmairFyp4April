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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umairfyp.model.Batsman_data.Batting;
import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.model.Batsman_data.Scorecard;
import com.example.umairfyp.network.RetrofitClient;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MatchSummaryActivity extends AppCompatActivity {


    Model_Batsman scorecard_model;
    RecyclerView rv1stbat,rv2ndbat,rv1stbowl,rv2ndbowl;

    TextView BatTeam1Tv,BatTeam2Tv,BowlTeam1Tv,BowlTeam2Tv,ExtraTv1,ExtraTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);


        Intent intent = getIntent();
        String id = intent.getStringExtra("match_id");
      //  String Team1 = intent.getStringExtra("Team1");

        //   BatTeam1Tv=findViewById(R.id.BatTeamName1);

        //   BatTeam1Tv.setText(Team1);

        // Binding the text views

        rv1stbat = findViewById(R.id.rv_1stBat);
        rv1stbat.setHasFixedSize(true);
        rv1stbat.setLayoutManager(new LinearLayoutManager(this));

        rv2ndbat = findViewById(R.id.rv_2ndBat);
        rv2ndbat.setHasFixedSize(true);
        rv2ndbat.setLayoutManager(new LinearLayoutManager(this));

        rv1stbowl = findViewById(R.id.rv_1stBowl);
        rv1stbowl.setHasFixedSize(true);
        rv1stbowl.setLayoutManager(new LinearLayoutManager(this));

        rv2ndbowl = findViewById(R.id.rv_2ndBowl);
        rv2ndbowl.setHasFixedSize(true);
        rv2ndbowl.setLayoutManager(new LinearLayoutManager(this));


        RetrofitClient.getInstance().getServices().getScorecard(id).enqueue(new Callback<Model_Batsman>() {
            @Override
            public void onResponse(Call<Model_Batsman> call, retrofit2.Response<Model_Batsman> response) {

                 scorecard_model = response.body();
                if(scorecard_model.getData().getScorecard().size()>0) {
                    if (scorecard_model != null) {
                        BatsmanAdapter batsmanAdapter = new BatsmanAdapter(scorecard_model.getData().getScorecard().get(0).getBatting());
                        rv1stbat.setAdapter(batsmanAdapter);
                    }
                    if(scorecard_model != null){
                        BowlerAdapter bowlerAdapter = new BowlerAdapter (scorecard_model.getData().getScorecard().get(0).getBowling());
                        rv1stbowl.setAdapter(bowlerAdapter);
                    }
                }
                if(scorecard_model.getData().getScorecard().size()>1) {
                    if (scorecard_model != null) {
                        BatsmanAdapter batsmanAdapter2 = new BatsmanAdapter(scorecard_model.getData().getScorecard().get(1).getBatting());
                        rv2ndbat.setAdapter(batsmanAdapter2);
                    }
                    if (scorecard_model != null) {
                        BowlerAdapter bowlerAdapter2 = new BowlerAdapter(scorecard_model.getData().getScorecard().get(1).getBowling());
                        rv2ndbowl.setAdapter(bowlerAdapter2);
                    }
                }

            }

            @Override
            public void onFailure(Call<Model_Batsman> call, Throwable t) {

            }
        });


    }
}