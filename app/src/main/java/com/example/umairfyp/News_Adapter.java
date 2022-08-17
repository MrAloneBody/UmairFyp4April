package com.example.umairfyp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.News.Article;
import com.example.umairfyp.News.Model_news;

import java.util.List;

public class News_Adapter extends RecyclerView.Adapter<News_Adapter.ViewHolder> {

    private List<Model_news> news_list;
    private Context context;

    public News_Adapter(List<Model_news> news_list, FragmentActivity activity) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_news,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model_news model = news_list.get(position);
        holder.title.setText(model.getArticles().get(position).getTitle());
        holder.description.setText(model.getArticles().get(position).getDescription());
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
