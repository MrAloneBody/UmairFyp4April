package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.umairfyp.model.players_list.Player;
import com.example.umairfyp.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersListActivity extends AppCompatActivity {

    String apiKey = "7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f";
    Player playerModel;
    RecyclerView rv,rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);
        rv = findViewById(R.id.rv_players_list_1st);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv2 = findViewById(R.id.rv_players_list_2nd);
        rv2.setLayoutManager(new LinearLayoutManager(this));

        RetrofitClient.getInstance().getServices().getPlayersList(apiKey, 0).enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                playerModel = response.body();
                if (playerModel != null) {
                    PlayersListAdapter_1st playersListAdapter1st = new PlayersListAdapter_1st(playerModel.getData());
                    rv.setAdapter(playersListAdapter1st);
                }
                if (playerModel != null) {
                    PlayerListAdapter2nd playersListAdapter2nd = new PlayerListAdapter2nd(playerModel.getData());
                    rv2.setAdapter(playersListAdapter2nd);
                }
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {

            }
        });
    }
}