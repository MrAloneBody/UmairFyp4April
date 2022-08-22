package com.example.umairfyp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.News.Article;
import com.example.umairfyp.R;

import java.util.List;

public class News_Adapter extends RecyclerView.Adapter<News_Adapter.ViewHolder> {

    private List<Article> news_list;
    private Context context;

    public News_Adapter(List<Article> news_list, FragmentActivity activity) {
        this.news_list = news_list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_news,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Article model = news_list.get(position);
   //     Log.d("NewsListSize", String.valueOf(news_list.size()));
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {

        return news_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.Title);
            description=itemView.findViewById(R.id.Description);

        }
    }


}
