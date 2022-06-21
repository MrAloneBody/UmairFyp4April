package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.umairfyp.model.players_list.PlayersList;
import com.example.umairfyp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersListActivity extends AppCompatActivity {

    PlayersList playerModel;
    RecyclerView rv,rv2;
    TextView team1tv,team2tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);
        rv = findViewById(R.id.rv_players_list_1st);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv2 = findViewById(R.id.rv_players_list_2nd);
        rv2.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String id= intent.getStringExtra("match_id");
      //  String Team1= intent.getStringExtra("Team1");
     //   String Team2 = intent.getStringExtra("Team2");

        team1tv=findViewById(R.id.PlayerTeamName1);
        team2tv=findViewById(R.id.PlayerTeamName2);

    //    team1tv.setText(playerModel.getData().get(0).getTeamName());
    //    team2tv.setText(playerModel.getData().get(1).getTeamName());


        RetrofitClient.getInstance().getServices().getPlayersList(id).enqueue(new Callback<PlayersList>() {
            @Override
            public void onResponse(Call<PlayersList> call, Response<PlayersList> response) {
                playerModel = response.body();

                if (playerModel != null) {
                    PlayersListAdapter1st playersListAdapter1st = new PlayersListAdapter1st(playerModel.getData().get(0).getPlayers());
                    rv.setAdapter(playersListAdapter1st);
                }
                if (playerModel != null) {
                    PlayersListAdapter1st playersListAdapter2nd = new PlayersListAdapter1st(playerModel.getData().get(1).getPlayers());
                    rv2.setAdapter(playersListAdapter2nd);
                }
            }

            @Override
            public void onFailure(Call<PlayersList> call, Throwable t) {

            }
        });
    }
}