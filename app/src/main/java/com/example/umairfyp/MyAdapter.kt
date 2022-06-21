package com.example.umairfyp
/*
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umairfyp.model.Data

class MyAdapter(var context: Context, var myList:List<Data>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder (val binding: RowMatchBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = myList[position]
        holder.binding.team1tv.text = model.teams[0]
        holder.binding.team2tv.text = model.teams[1]
        holder.binding.matchstatustv.text = model.status
        holder.binding.datetv.text = model.date

//        holder.itemView.setOnClickListener { mListener?.setOnItemClickListener(village) }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    private var mListener: OnItemClick? = null
    interface OnItemClick {
        fun setOnItemClickListener(item: Data)
    }

    fun setOnClickListener(onItemClick: OnItemClick) {
        mListener = onItemClick
    }
}
*/