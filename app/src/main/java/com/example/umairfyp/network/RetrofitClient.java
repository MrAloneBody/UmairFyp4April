package com.example.umairfyp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient retrofitClient;

    public static RetrofitClient getInstance(){
        if(retrofitClient==null){
            return retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }
    private Retrofit retrofit;

    private  RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.cricapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public Services getServices(){
       return retrofit.create(Services.class);
    }
}
