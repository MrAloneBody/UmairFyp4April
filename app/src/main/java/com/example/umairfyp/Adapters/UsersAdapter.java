package com.example.umairfyp.Adapters;

import androidx.recyclerview.widget.RecyclerView;

import com.example.umairfyp.databinding.ItemContainerUserBinding;
import com.example.umairfyp.model.Comment_models.User;

public class UsersAdapter {
    class UsersViewHolder extends RecyclerView.ViewHolder{
        ItemContainerUserBinding binding;
        UsersViewHolder(ItemContainerUserBinding itemContainerUserBinding){
            super(itemContainerUserBinding.getRoot());
            binding = itemContainerUserBinding;
        }
        void setUserdata(User user){
            binding.textname.setText(user.name);
            binding.textemail.setText(user.email);
        }

    }
}
