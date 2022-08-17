package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.umairfyp.Adapters.PlayersListAdapter1st;
import com.example.umairfyp.model.players_list.PlayersList;
import com.example.umairfyp.network.RetrofitClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersListActivity extends AppCompatActivity {

    PlayersList playerModel;
    RecyclerView rv,rv2;
    TextView team1tv,team2tv;
    ImageView player_image;
    String Player_img_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        player_image= (ImageView) findViewById(R.id.Playerimg);

        Context context = this;

        //setting recycler Views
        rv = findViewById(R.id.rv_players_list_1st);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv2 = findViewById(R.id.rv_players_list_2nd);
        rv2.setLayoutManager(new LinearLayoutManager(this));

        //Getting Intent
        Intent intent = getIntent();
        String id= intent.getStringExtra("match_id");

        team1tv=findViewById(R.id.PlayerTeamName1);
        team2tv=findViewById(R.id.PlayerTeamName2);


        RetrofitClient.getInstance().getServices().getPlayersList(id).enqueue(new Callback<PlayersList>() {
            @Override
            public void onResponse(Call<PlayersList> call, Response<PlayersList> response) {
                playerModel = response.body();

                team1tv.setText(playerModel.getData().get(0).getTeamName());
                team2tv.setText(playerModel.getData().get(1).getTeamName());

                if (playerModel != null) {
                    PlayersListAdapter1st playersListAdapter1st = new PlayersListAdapter1st(playerModel.getData().get(0).getPlayers());
                    Player_img_url = playerModel.getData().get(0).getPlayers().get(0).getPlayerImg();
                 //   Glide.with(context).load(PLayer_img_url).into(player_image);
                    Picasso.get().load(Player_img_url).into(player_image);
                    rv.setAdapter(playersListAdapter1st);
                }
                if (playerModel != null) {
                    PlayersListAdapter1st playersListAdapter2nd = new PlayersListAdapter1st(playerModel.getData().get(1).getPlayers());
                    Player_img_url = playerModel.getData().get(1).getPlayers().get(1).getPlayerImg();
                  //  Glide.with(context).load(PLayer_img_url).into(player_image);
                    Picasso.get().load(Player_img_url).into(player_image);
                    rv2.setAdapter(playersListAdapter2nd);
                }
            }

            @Override
            public void onFailure(Call<PlayersList> call, Throwable t) {

            }
        });
    }
}