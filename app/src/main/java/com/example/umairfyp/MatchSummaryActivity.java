package com.example.umairfyp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.umairfyp.Adapters.BatsmanAdapter;
import com.example.umairfyp.Adapters.BowlerAdapter;
import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;


public class MatchSummaryActivity extends AppCompatActivity {


    Model_Batsman scorecard_model;
    RecyclerView rv1stbat,rv2ndbat,rv1stbowl,rv2ndbowl,rv3rdbat,rv4thbat,rv3rdbowl,rv4thbowl;
    LinearLayout bat1st,bat2nd,bat3rd,bat4th;
    TextView mScore1Tv,mScore2Tv,mWickets1Tv,mOvers1Tv,mWickets2Tv,mOvers2Tv;
    TextView mScore3Tv,mScore4Tv,mOvers3Tv,mOvers4Tv,mWickets3Tv,mWickets4Tv;

    TextView BatTeam1Tv,BatTeam2Tv,BatTeam3Tv,BatTeam4Tv,ExtraTv1,ExtraTv2,ExtraTv3,ExtraTv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);


        Intent intent = getIntent();
        String id = intent.getStringExtra("match_id");

        String Score1 = intent.getStringExtra("Score1");
        String Score2 = intent.getStringExtra("Score2");
        String Score3 = intent.getStringExtra("Score3");
        String Score4 = intent.getStringExtra("Score4");

        String Wickets1 = intent.getStringExtra("Wickets1");
        String Wickets2 = intent.getStringExtra("Wickets2");
        String Wickets3 = intent.getStringExtra("Wickets3");
        String Wickets4 = intent.getStringExtra("Wickets4");

        String Overs1 = intent.getStringExtra("Overs1");
        String Overs2 = intent.getStringExtra("Overs2");
        String Overs3 = intent.getStringExtra("Overs3");
        String Overs4 = intent.getStringExtra("Overs4");



        BatTeam1Tv=findViewById(R.id.BatTeamName1);
        BatTeam2Tv=findViewById(R.id.BatTeamName2);
        BatTeam3Tv=findViewById(R.id.BatTeamName3);
        BatTeam4Tv=findViewById(R.id.BatTeamName4);

        ExtraTv1 = findViewById(R.id.extra_1stinning);
        ExtraTv2 = findViewById(R.id.extra_2ndinning);
        ExtraTv3 = findViewById(R.id.extra_3rdinning);
        ExtraTv4 = findViewById(R.id.extra_4thinning);

        //binding linear layouts
        bat1st = findViewById(R.id.inning_1st);
        bat2nd = findViewById(R.id.inning_2nd);
        bat3rd = findViewById(R.id.inning_3rd);
        bat4th = findViewById(R.id.inning_4th);



        mScore1Tv = findViewById(R.id.score1);
        mScore2Tv = findViewById(R.id.score2);
        mWickets1Tv = findViewById(R.id.wicket1);
        mWickets2Tv = findViewById(R.id.wicket2);
        mOvers1Tv = findViewById(R.id.over1);
        mOvers2Tv = findViewById(R.id.over2);
        mScore3Tv = findViewById(R.id.score3);
        mScore4Tv = findViewById(R.id.score4);
        mWickets3Tv = findViewById(R.id.wicket3);
        mWickets4Tv = findViewById(R.id.wicket4);
        mOvers3Tv = findViewById(R.id.over3);
        mOvers4Tv = findViewById(R.id.over4);


        mScore1Tv.setText(Score1);
        mScore3Tv.setText(Score3);
        mScore2Tv.setText(Score2);
        mScore4Tv.setText(Score4);
        mWickets1Tv.setText(Wickets1);
        mWickets2Tv.setText(Wickets2);
        mWickets3Tv.setText(Wickets3);
        mWickets4Tv.setText(Wickets4);
        mOvers1Tv.setText(Overs1);
        mOvers2Tv.setText(Overs2);
        mOvers3Tv.setText(Overs3);
        mOvers4Tv.setText(Overs4);

        //setting recycler  views
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

        rv3rdbat = findViewById(R.id.rv_3rdBat);
        rv3rdbat.setHasFixedSize(true);
        rv3rdbat.setLayoutManager(new LinearLayoutManager(this));

        rv3rdbowl = findViewById(R.id.rv_3rdBowl);
        rv3rdbowl.setHasFixedSize(true);
        rv3rdbowl.setLayoutManager(new LinearLayoutManager(this));

        rv4thbat = findViewById(R.id.rv_4thBat);
        rv4thbat.setHasFixedSize(true);
        rv4thbat.setLayoutManager(new LinearLayoutManager(this));

        rv4thbowl = findViewById(R.id.rv_4thBowl);
        rv4thbowl.setHasFixedSize(true);
        rv4thbowl.setLayoutManager(new LinearLayoutManager(this));


        RetrofitClient.getInstance().getServices().getScorecard(id).enqueue(new Callback<Model_Batsman>() {
            @Override
            public void onResponse(Call<Model_Batsman> call, retrofit2.Response<Model_Batsman> response) {

                 scorecard_model = response.body();


                 //Setting Adapter with recyclerView and data binding with text views


                //1st inning ScoreCard
                if(scorecard_model.getData().getScorecard().size()==0){
                    Toast.makeText(MatchSummaryActivity.this, "Match Not Started ", Toast.LENGTH_SHORT).show();

                 //   bat1st.setVisibility(View.GONE);
                }

                if(scorecard_model.getData().getScorecard().size()>0) {
                    if (scorecard_model != null) {
                        BatsmanAdapter batsmanAdapter = new BatsmanAdapter(scorecard_model.getData().getScorecard().get(0).getBatting());
                        rv1stbat.setAdapter(batsmanAdapter);
                        String Team1=scorecard_model.getData().getScorecard().get(0).getInning();
                        BatTeam1Tv.setText(Team1);
                    }
                    if(scorecard_model != null){
                        BowlerAdapter bowlerAdapter = new BowlerAdapter (scorecard_model.getData().getScorecard().get(0).getBowling());
                        rv1stbowl.setAdapter(bowlerAdapter);
                        //For showing Extras of 1st inning
                        ExtraTv1.setText(scorecard_model.getData().getScorecard().get(0).getExtras().getR());


                    }
                }


                //2nd Inning ScoreCard
                if(scorecard_model.getData().getScorecard().size()<2){
                    bat2nd.setVisibility(View.GONE);
                }
                if(scorecard_model.getData().getScorecard().size()>1) {
                    if (scorecard_model != null) {
                        BatsmanAdapter batsmanAdapter2 = new BatsmanAdapter(scorecard_model.getData().getScorecard().get(1).getBatting());
                        rv2ndbat.setAdapter(batsmanAdapter2);
                        String Team2=scorecard_model.getData().getScorecard().get(1).getInning();
                        BatTeam2Tv.setText(Team2);
                    }
                    if (scorecard_model != null) {
                        BowlerAdapter bowlerAdapter2 = new BowlerAdapter(scorecard_model.getData().getScorecard().get(1).getBowling());
                        rv2ndbowl.setAdapter(bowlerAdapter2);

                        //For showing Extras of 2nd inning
                        ExtraTv2.setText(scorecard_model.getData().getScorecard().get(1).getExtras().getR());

                    }
                }

                //3rd Inning ScoreCard
                if(scorecard_model.getData().getScorecard().size()<3){
                    bat3rd.setVisibility(View.GONE);
                }
                if(scorecard_model.getData().getScorecard().size()>2) {
                    if (scorecard_model != null) {
                        BatsmanAdapter batsmanAdapter3 = new BatsmanAdapter(scorecard_model.getData().getScorecard().get(2).getBatting());
                        rv3rdbat.setAdapter(batsmanAdapter3);
                        String Team3=scorecard_model.getData().getScorecard().get(2).getInning();
                        BatTeam3Tv.setText(Team3);
                    }
                    if(scorecard_model != null){
                        BowlerAdapter bowlerAdapter3 = new BowlerAdapter (scorecard_model.getData().getScorecard().get(2).getBowling());
                        rv3rdbowl.setAdapter(bowlerAdapter3);
                        //For showing Extras of 3rd inning
                        ExtraTv3.setText(scorecard_model.getData().getScorecard().get(2).getExtras().getR());


                    }
                }

                //4th Inning ScoreCard
                if(scorecard_model.getData().getScorecard().size()<4){
                    bat4th.setVisibility(View.GONE);
                }
                if(scorecard_model.getData().getScorecard().size()>3) {
                    if (scorecard_model != null) {
                        BatsmanAdapter batsmanAdapter4 = new BatsmanAdapter(scorecard_model.getData().getScorecard().get(3).getBatting());
                        rv4thbat.setAdapter(batsmanAdapter4);
                        String Team4=scorecard_model.getData().getScorecard().get(3).getInning();
                        BatTeam4Tv.setText(Team4);
                    }
                    if (scorecard_model != null) {
                        BowlerAdapter bowlerAdapter4 = new BowlerAdapter(scorecard_model.getData().getScorecard().get(3).getBowling());
                        rv4thbowl.setAdapter(bowlerAdapter4);

                        //For showing Extras of 4th inning
                        ExtraTv4.setText(scorecard_model.getData().getScorecard().get(3).getExtras().getR());

                    }
                }
            }

            @Override
            public void onFailure(Call<Model_Batsman> call, Throwable t) {

            }
        });


    }
}