package com.example.umairfyp.network;

import com.example.umairfyp.News.Model_news;
import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.model.Model;
import com.example.umairfyp.model.players_list.PlayersList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services_news {


    @GET("top-headlines?country=in&category=sports&apiKey=3130b87889c94b4da1915b306b3755ac")
    Call<Model_news> getNews(

    );

}
