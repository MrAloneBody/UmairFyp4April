package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.umairfyp.model.Data;
import com.example.umairfyp.model.Model;
import com.example.umairfyp.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;


    //for API
    private String url= "https://api.cricapi.com/v1/currentMatches?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f&offset=0";

    private RecyclerView.Adapter newAdapter;
    private List<Data> newModelList;

    TextView news_frag,feedback_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        news_frag = findViewById(R.id.News_fragment);
        feedback_frag = findViewById(R.id.Feedback_fragment);

        //recyclerview
        mRecyclerView = findViewById(R.id.recyclerview);
        //set its properties
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newModelList = new ArrayList<>();

        // Function to get show data from website
        loadUrlData();


        news_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new News_fragment());

            }
        });

        feedback_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new Feedback_fragment());

            }
        });

    }

    private void loadUrlData() {

        //progress bar to be displayed while data is retrieving
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        RetrofitClient.getInstance().getServices().getCurrentMatches().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, retrofit2.Response<Model> response) {
                if (!response.isSuccessful()) {
                    Log.d("debugging", response.message());
                    return;
                }
                if (response.body() != null){
                    pd.dismiss();
                    newModelList = (response.body().getData());
                    newAdapter = new Adapter(newModelList, getApplicationContext());
                    mRecyclerView.setAdapter(newAdapter);
                }
                else
                    Toast.makeText(MainActivity.this, "No Response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("debugging", t.getMessage());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,fragment);
        fragmentTransaction.commit();

    }
}