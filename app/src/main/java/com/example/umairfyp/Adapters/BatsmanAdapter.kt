package com.example.umairfyp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umairfyp.databinding.RowBatsmanBinding
import com.example.umairfyp.model.Batsman_data.Batting
import com.example.umairfyp.model.players_list.Data


class BatsmanAdapter(private var scorecard: List<Batting>) : RecyclerView.Adapter<BatsmanAdapter.ViewHolder>(){


    class ViewHolder (val binding: RowBatsmanBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBatsmanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var player = scorecard[position]
        holder.binding.BatsmanName.text = player.batsman.name
        holder.binding.Dismissal.text = player.dismissalText
        holder.binding.BatsmanScore.text = player.r.toString()
        holder.binding.BatsmanBowlsFaced.text = player.b.toString()
        holder.binding.BatsmanSr.text = player.sr.toString()

//        holder.itemView.setOnClickListener { mListener?.setOnItemClickListener(village) }
    }

    override fun getItemCount(): Int {
        return scorecard.size
    }

    private var mListener: OnItemClick? = null
    interface OnItemClick {
        fun setOnItemClickListener(item: Data)
    }

    fun setOnClickListener(onItemClick: OnItemClick) {
        mListener = onItemClick
    }
}

