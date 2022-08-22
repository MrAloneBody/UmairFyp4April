package com.example.umairfyp.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.databinding.ItemContainerRecievedMessageBinding;
import com.example.umairfyp.databinding.ItemContainerSentMessageBinding;
import com.example.umairfyp.model.Comment_models.CommentMessage;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final List<CommentMessage> commentMessages;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1 ;
    public static final int VIEW_TYPE_RECIEVED = 2 ;

    public CommentAdapter(List<CommentMessage> commentMessages, String senderId) {
        this.commentMessages = commentMessages;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_SENT){
            return new ReceivedMessageViewHolder(ItemContainerRecievedMessageBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
        }
        else
        {
            return new ReceivedMessageViewHolder(ItemContainerRecievedMessageBinding.inflate(
                    LayoutInflater.from(parent.getContext()),parent,false
            ));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position)==VIEW_TYPE_SENT){
            ((ReceivedMessageViewHolder)holder).setData(commentMessages.get(position));
        }else{
            ((ReceivedMessageViewHolder)holder).setData(commentMessages.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return commentMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(commentMessages.get(position).senderId.equals(senderId)){
            return VIEW_TYPE_SENT;
        }else
        {
            return VIEW_TYPE_RECIEVED;
        }
    }

    static class SentMessageViewHolder extends RecyclerView.ViewHolder{

        private final ItemContainerSentMessageBinding binding;
        SentMessageViewHolder(ItemContainerSentMessageBinding itemContainerSentMessageBinding){
            super(itemContainerSentMessageBinding.getRoot());
            binding = itemContainerSentMessageBinding;
        }
        void setData(CommentMessage commentMessage){
            binding.textmessage.setText(CommentMessage.message);

        }
    }

    static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder{

        private final ItemContainerRecievedMessageBinding binding;

        ReceivedMessageViewHolder(ItemContainerRecievedMessageBinding itemContainerRecievedMessageBinding){

            super(itemContainerRecievedMessageBinding.getRoot());
            binding = itemContainerRecievedMessageBinding;
        }
        void setData(CommentMessage commentMessage){
            binding.recievedMessage.setText(CommentMessage.message);
        }
    }
}
