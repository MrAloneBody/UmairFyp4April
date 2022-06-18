package com.example.umairfyp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umairfyp.databinding.RowPlayersBinding
import com.example.umairfyp.model.players_list.Data
import com.example.umairfyp.model.players_list.Player

class PlayersListAdapter1st(private var playersList: MutableList<Player>) : RecyclerView.Adapter<PlayersListAdapter1st.ViewHolder>(){

    class ViewHolder (val binding: RowPlayersBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowPlayersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var player = playersList[position]

        holder.binding.playerName.text = player.name
        holder.binding.battingStyle.text = player.battingStyle
        holder.binding.playerRole.text = player.role
//        holder.itemView.setOnClickListener { mListener?.setOnItemClickListener(village) }
    }

    override fun getItemCount(): Int {
        return playersList.size
    }

    private var mListener: OnItemClick? = null
    interface OnItemClick {
        fun setOnItemClickListener(item: Data)
    }

    fun setOnClickListener(onItemClick: OnItemClick) {
        mListener = onItemClick
    }
}
