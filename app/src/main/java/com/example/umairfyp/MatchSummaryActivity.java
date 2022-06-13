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


public class MatchSummaryActivity extends AppCompatActivity {

    String url="https://api.cricapi.com/v1/match_scorecard?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f&id";

    Scorecard scorecard_model;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);
        rv = findViewById(R.id.rv_1stBat);
        rv.setLayoutManager(new LinearLayoutManager(this));


        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Players Details");
        //Back button
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent= getIntent();
        String uniqueId = intent.getStringExtra("match_id");
        
        //Load Data
        loadData();

    }

    private void loadData() {

        //progress bar to be displayed while data is retrieving
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();


        StringRequest stringRequest= new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //dismiss dialog
                pd.dismiss();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MatchSummaryActivity.this, "Error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //enqueue req

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }




    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();//goto prev activity


        return super.onSupportNavigateUp();
    }
}