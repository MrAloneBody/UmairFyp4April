package com.example.umairfyp.network;


import com.example.umairfyp.model.Batsman_data.Model_Batsman;
import com.example.umairfyp.model.Batsman_data.Scorecard;
import com.example.umairfyp.model.Model;
import com.example.umairfyp.model.players_list.Player;
import com.example.umairfyp.model.players_list.PlayersList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {

    @GET("currentMatches?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f&offset=0")
    Call<Model> getCurrentMatches(
    );

    @GET("match_squad?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f")
    Call<PlayersList> getPlayersList(
           @Query("id") String id
    );

    @GET("match_scorecard?apikey=7d2dc5ae-9763-41fe-8f0d-00217c6a0d8f")
    Call<Model_Batsman> getScorecard(
            @Query("id") String id
    );


//    @GET("list_movies.json")
//    Call<Model> getMoviesList(
//            @Query("limit")int limit
//            , @Query("page")int page
//            , @Query("quality")String quality
//            , @Query("minimum_rating") int minimumRating
//            , @Query("query_term") String query
//            , @Query("genre")String genre
//            , @Query("sort_by") String sortBy
//            , @Query("order_by") String orderBy
//    );
}
