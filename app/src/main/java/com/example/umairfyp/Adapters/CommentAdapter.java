package com.example.umairfyp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.R;
import com.example.umairfyp.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    List<Comment> comments;
    TextView profileName;
    TextView receivedMessage;

    public CommentAdapter(List<Comment> cast) {
        this.comments = cast;
    }

    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_container_recieved_message, parent, false);
        profileName = view.findViewById(R.id.profile_name);
        receivedMessage = view.findViewById(R.id.received_message);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        //setting actor name
        Comment comment = comments.get(position);
        profileName.setText(comment.getName());
        receivedMessage.setText(comment.getMessage());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void updateList(List<Comment> _comments){
        comments.clear();
        comments.addAll(_comments);
        notifyDataSetChanged();
    }
}
