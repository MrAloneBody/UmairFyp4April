package com.example.umairfyp;

import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.databinding.ItemContainerSentMessageBinding;

public class Comment_Adapter {

    static class SentMessageViewHolder extends RecyclerView.ViewHolder{

        private final ItemContainerSentMessageBinding binding;

        SentMessageViewHolder(ItemContainerSentMessageBinding itemContainerSentMessageBinding){
            super(itemContainerSentMessageBinding.getRoot());
            binding = itemContainerSentMessageBinding;
        }

    }
}
