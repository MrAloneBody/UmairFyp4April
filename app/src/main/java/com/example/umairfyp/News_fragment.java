package com.example.umairfyp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umairfyp.News.Model_news;
import com.example.umairfyp.model.Model;
import com.example.umairfyp.network.RetrofitClient;
import com.example.umairfyp.network.Retrofit_news;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class News_fragment extends Fragment {

    private RecyclerView news_Recycler_View;
    String news_url = "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=3130b87889c94b4da1915b306b3755ac";

    private RecyclerView.Adapter News_Adapter;
    private List<Model_news> news_list;
    View view;

    Retrofit_news.
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_fragment, container, false);

        news_Recycler_View = view.findViewById(R.id.News_recycler_view);

        news_Recycler_View.setHasFixedSize(true);
        news_Recycler_View.setLayoutManager(new LinearLayoutManager(getActivity()));

        news_list = new ArrayList<>();

        loadUrlData();

        return view;

    }

    private void loadUrlData() {
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, news_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                pd.dismiss();

                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("articles");
                    for (int i=0 ; i<jsonArray.length();i++)
                    {
                        try {
                            String title = jsonArray.getJSONObject(i).getString("title");
                            String description = jsonArray.getJSONObject(i).getString("description");

                            Model_news model = new Model_news(title,description);

                            news_list.add(model);
                        }
                        catch (Exception e){
                            Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    News_Adapter = new News_Adapter(news_list,getActivity());
                    news_Recycler_View.setAdapter(News_Adapter);

                }
                catch (Exception e){
                    Toast.makeText(getActivity(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error :" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

     */
}