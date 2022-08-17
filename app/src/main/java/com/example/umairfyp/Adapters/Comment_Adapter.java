package com.example.umairfyp.Adapters;

import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.databinding.ItemContainerSentMessageBinding;
import com.example.umairfyp.model.Comment_models.CommentMessage;

import java.util.List;

public class Comment_Adapter {

    public Comment_Adapter(List<CommentMessage> commentMessages, String string) {

    }

    static class SentMessageViewHolder extends RecyclerView.ViewHolder{

        private final ItemContainerSentMessageBinding binding;

        SentMessageViewHolder(ItemContainerSentMessageBinding itemContainerSentMessageBinding){
            super(itemContainerSentMessageBinding.getRoot());
            binding = itemContainerSentMessageBinding;
        }

    }
}
