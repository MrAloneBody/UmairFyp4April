package com.example.umairfyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.umairfyp.Adapters.Adapter;
import com.example.umairfyp.SignIN_UP.SignInActivity;
import com.example.umairfyp.Utilities.Constants;
import com.example.umairfyp.Utilities.PrefrenceManager1;
import com.example.umairfyp.databinding.ActivityMainBinding;
import com.example.umairfyp.model.Data;
import com.example.umairfyp.model.Model;
import com.example.umairfyp.network.RetrofitClient;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter newAdapter;
    private List<Data> newModelList;

    PrefrenceManager1 prefrenceManager1;
    TextView news_frag,feedback_frag;
    FrameLayout frag_layout;
    ScrollView current_matches_layout;
    ImageView signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        news_frag = findViewById(R.id.News_fragment);
        feedback_frag = findViewById(R.id.Feedback_fragment);
        signout = findViewById(R.id.Sign_out_img);

        frag_layout = findViewById(R.id.fragment_layout);
        current_matches_layout = findViewById(R.id.Current_matches_layout);

        //recyclerview
        mRecyclerView = findViewById(R.id.recyclerview);
        //set its properties
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newModelList = new ArrayList<>();

        // Function to get show data from website
        loadUrlData();


        Log.d("Working",Constants.KEY_IS_SIGNED_IN );


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }



        });





        news_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag_layout.setVisibility(View.VISIBLE);
                replaceFragment(new News_fragment());
                current_matches_layout.setVisibility(View.GONE);
            }
        });

        feedback_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frag_layout.setVisibility(View.VISIBLE);
                replaceFragment(new Feedback_fragment());
                current_matches_layout.setVisibility(View.GONE);

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
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        frag_layout.setVisibility(View.GONE);
        current_matches_layout.setVisibility(View.VISIBLE);

    }


    private void signOut(){
        Toast.makeText(this, "Signing out...", Toast.LENGTH_SHORT).show();
     //   Constants.KEY_IS_SIGNED_IN = String.valueOf(false);

        prefrenceManager1.putBoolean(Constants.KEY_IS_SIGNED_IN, false);
        startActivity(new Intent(getApplicationContext(), SignInActivity.class));

/*
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        prefrencEmanager.getString(Constants.KEY_USER_ID)
                );
        HashMap<String,Object> updates = new HashMap<>();
        updates.put(Constants.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    prefrencEmanager.clear();
                    startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Unable to signout.", Toast.LENGTH_SHORT).show();
                });
    }


 */


}}