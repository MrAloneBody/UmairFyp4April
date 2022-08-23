package com.example.umairfyp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_news {

    private static Retrofit_news retrofit_news;

    public static Retrofit_news getInstance_news(){
        if(retrofit_news==null){
            return retrofit_news = new Retrofit_news();
        }
        return retrofit_news;
    }
    private Retrofit retrofit;

    private  Retrofit_news() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public Services_news getServices_news(){
        return retrofit.create(Services_news.class);
    }
}
