package com.example.umairfyp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.model.Data;
import com.example.umairfyp.model.Model;

import java.util.List;


public class MatchDetailActivity extends AppCompatActivity {


    TextView mTeam1Tv, mTeam2Tv, mMatchStatusTv, mScore1Tv, mDateTv,mScore2Tv,mWickets1Tv,mOvers1Tv,mWickets2Tv,mOvers2Tv;
    TextView slash1,slash2,sp1,sp2,ep1,ep2;
    private String url= "https://api.cricapi.com/v1/match_info?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f&offset=0&id=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_details);

        //Actionbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Match Details");

        //Back button

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        slash1 = findViewById(R.id.Slash1);
        slash2 = findViewById(R.id.Slash2);
        ep1 = findViewById(R.id.EP1);
        ep2 = findViewById(R.id.EP2);
        sp1 = findViewById(R.id.SP1);
        sp2 = findViewById(R.id.SP2);


        //get data from intent (Onclick from previous activity)
        Intent intent = getIntent();
     //   String id= intent.getStringExtra("match_id");
        String date = intent.getStringExtra("date");
        String Team1= intent.getStringExtra("Team1");
        String Score1 = intent.getStringExtra("Score1");
        String Team2 = intent.getStringExtra("Team2");
        String Score2 = intent.getStringExtra("Score2");
        String MatchStatus= intent.getStringExtra("MatchStatus");
        String Wickets1 = intent.getStringExtra("Wickets1");
        String Wickets2 = intent.getStringExtra("Wickets2");
        String Overs1 = intent.getStringExtra("Overs1");
        String Overs2 = intent.getStringExtra("Overs2");
        int inning_size = intent.getIntExtra("innings_size",0);

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


        mDateTv.setText(date);
        mTeam1Tv.setText(Team1);
        mScore1Tv.setText(Score1);
        mTeam2Tv.setText(Team2);
        mScore2Tv.setText(Score2);
        mMatchStatusTv.setText(MatchStatus);
        mWickets1Tv.setText(Wickets1);
        mWickets2Tv.setText(Wickets2);
        mOvers1Tv.setText(Overs1);
        mOvers2Tv.setText(Overs2);


        //get set data
        loadData();

    }

    private void loadData() {
        //progress bar to be displayed while data is retrieving
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //this method will be called when the response from the server is received, dismiss the dialog first

                        pd.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //if anything gets wrong, get the show error message
                Toast.makeText(MatchDetailActivity.this,"Error "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //enqueue the req
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();//goto prev activity


        return super.onSupportNavigateUp();
    }
}