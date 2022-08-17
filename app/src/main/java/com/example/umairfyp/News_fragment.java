package com.example.umairfyp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.umairfyp.News.Article;
import com.example.umairfyp.News.Model_news;
import com.example.umairfyp.network.Retrofit_news;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News_fragment extends Fragment {

    private RecyclerView news_Recycler_View;
    Model_news model_news;
    TextView title,description;

    private RecyclerView.Adapter News_Adapter;
    private List<Article> news_list;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_fragment, container, false);

        news_Recycler_View = view.findViewById(R.id.News_recycler_view);

        news_Recycler_View.setHasFixedSize(true);
        news_Recycler_View.setLayoutManager(new LinearLayoutManager(getActivity()));

        title = view.findViewById(R.id.Title);
        description = view.findViewById(R.id.Description);

        Retrofit_news.getInstance_news().getServices_news().getNews().enqueue(new Callback<Model_news>() {
            @Override
            public void onResponse(Call<Model_news> call, Response<Model_news> response) {
                model_news = response.body();

             news_list = (response.body().getArticles());

             News_Adapter = new News_Adapter(news_list,getActivity());
             news_Recycler_View.setAdapter(News_Adapter);
            }

            @Override
            public void onFailure(Call<Model_news> call, Throwable t) {

            }
        });

        return view;

    }
}