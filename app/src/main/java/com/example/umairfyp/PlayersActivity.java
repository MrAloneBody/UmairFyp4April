package com.example.umairfyp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlayersActivity extends AppCompatActivity {

    ListView team1_players_list,team2_players_list;
    TextView team1NameTv ,team2NameTv, team1PlayersTv ,team2PlayersTv;
    private String url = " https://api.cricapi.com/v1/match_squad?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f&id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        team1_players_list=(ListView) findViewById(R.id.Team1Playerslisttv);
        team2_players_list=(ListView) findViewById(R.id.Team2Playerslisttv);
        ArrayList<TextView> arrayList = new ArrayList<>();
        arrayList.add(team1NameTv);
        arrayList.add(team2NameTv);

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        team2_players_list.setAdapter(arrayAdapter);
        team1_players_list.setAdapter(arrayAdapter);


        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Players Details");
        //Back button
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent= getIntent();
        String uniqueid = intent.getStringExtra("match_id");
        String team1Name= intent.getStringExtra("Team1");
        String team2Name= intent.getStringExtra("Team2");

        url = url + uniqueid;

        team1NameTv = findViewById(R.id.team1NameTv);
        team2NameTv = findViewById(R.id.team2NameTv);
   //     team1PlayersTv = findViewById(R.id.team1PlayersTv);
 //       team2PlayersTv = findViewById(R.id.team2PlayersTv);


        team1NameTv.setText(team1Name);
        team2NameTv.setText(team2Name);

        //load data function call
        loadData();

    }

    private void loadData() {
        //progress bar to be displayed while data is retrieving
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // dismiss dialog
                pd.dismiss();
                 /*json data is in response variable parameter of this function
                        it may cause exception so we will use try catch*/
 /*               try {

                    JSONArray squadArray = new JSONObject(response).getJSONArray("data");

                    JSONObject json0 = squadArray.getJSONObject(0);
                    JSONObject json1 = squadArray.getJSONObject(1);

                    JSONArray team1Array = json0.getJSONArray("Players");
                    JSONArray team2Array = json1.getJSONArray("Players");

                    //get players name  of  team1
                    for (int i=0; i<team1Array.length(); i++)
                    {
                        String team1 = team1Array.getJSONObject(i).getString("name");
                        team1PlayersTv.append((i+1)+") "+ team1 + "\n");
                    }

                    //get players name  of  team2
                    for (int i=0; i<team2Array.length(); i++)
                    {
                        String team2 = team2Array.getJSONObject(i).getString("name");
                        team2PlayersTv.append((i+1)+") "+ team2 + "\n");
                    }

                }
                catch (Exception  e){
                    Toast.makeText(PlayersActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(PlayersActivity.this, "Error : "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        // enqueue the req
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();//goto prev activity


        return super.onSupportNavigateUp();
    }

}