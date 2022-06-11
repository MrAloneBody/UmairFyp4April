package com.example.umairfyp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import com.example.umairfyp.model.Data;
import com.example.umairfyp.model.Model;

import java.util.List;


public class MatchDetailActivity extends AppCompatActivity {


    TextView mTeam1Tv, mTeam2Tv, mMatchStatusTv, mScore1Tv, mDateTv,mScore2Tv;
    String team1,team2,matchStatus,score1,score2;

    // we will get unique id of the match from on click(intent)


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

        //get data from intent (Onclick from previous activity)
        Intent intent = getIntent();
        String id= intent.getStringExtra("match_id");
        String date = intent.getStringExtra("date");
        String Team1= intent.getStringExtra("Team1");
        String Team1Score= intent.getStringExtra("Team1Score");
        String Team2 = intent.getStringExtra("Team2");
        String Team2Score = intent.getStringExtra("Team2Score");

        url = url + id;

        mTeam1Tv = findViewById(R.id.team1tv);
        mTeam2Tv = findViewById(R.id.team2tv);
        mMatchStatusTv = findViewById(R.id.matchstatustv);
        mScore1Tv = findViewById(R.id.score1Tv);
        mScore2Tv = findViewById(R.id.score2Tv);

        mDateTv = findViewById(R.id.datetv);

        mDateTv.setText(date);
        mTeam1Tv.setText(Team1);
        mScore1Tv.setText(Team1Score);
        mTeam2Tv.setText(Team2);
        mScore2Tv.setText(Team2Score);

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
                        //this method will be called when the response from the server is recieved, dismiss the dialog first


                        pd.dismiss();


                        /*json data is in response variable parameter of this function
                        it may cause exception so we will use try catch*/
                        try {


                            //set this data

                         //   mTeam1Tv.setText(Team1);
                         //   mTeam2Tv.setText(Team2);

                            mMatchStatusTv.setText(matchStatus);

                            try {
                                //these values will be received only if the match is started
                                // so we are enclosing this in a separate try catch

                                mScore1Tv.setText(score1);
                                mScore2Tv.setText(score2);


                            }
                            catch (Exception e){
                                Toast.makeText(MatchDetailActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (Exception e){
                            Toast.makeText(MatchDetailActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

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