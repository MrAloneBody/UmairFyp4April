package com.example.umairfyp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umairfyp.databinding.RowBatsmanBinding
import com.example.umairfyp.databinding.RowBowlerBinding
import com.example.umairfyp.databinding.RowPlayersBinding
import com.example.umairfyp.model.players_list.Data


class BowlerAdapter(private var playersList: List<Data>) : RecyclerView.Adapter<BowlerAdapter.ViewHolder>(){

    class ViewHolder (val binding: RowBowlerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBowlerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var player = playersList[position]
        holder.binding.BowlersName.text = player.name

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
