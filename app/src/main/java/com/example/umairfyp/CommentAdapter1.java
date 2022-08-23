package com.example.umairfyp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommentAdapter1 extends RecyclerView.Adapter<CommentAdapter1.MyViewHolder> {


    Context context;
    ArrayList<Comment> commentArrayList;

    public CommentAdapter1(Context context, ArrayList<Comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @NonNull
    @Override
    public CommentAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.row_comment,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter1.MyViewHolder holder, int position) {

        Comment comment = commentArrayList.get(position);
        holder.SenderId.setText(comment.senderId);
        holder.Comment.setText(comment.message);

    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView SenderId,Comment;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            SenderId = itemView.findViewById(R.id.Senderid);
            Comment = itemView.findViewById(R.id.Comment);
        }
    }
}
