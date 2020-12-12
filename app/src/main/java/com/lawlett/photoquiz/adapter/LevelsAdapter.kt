package com.lawlett.photoquiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.databinding.LevelItemBinding

class LevelsAdapter (private val listener: Listener):
    RecyclerView.Adapter<LevelsAdapter.LevelsViewHolder>() {
    private var list = listOf<Level>()

    class LevelsViewHolder(private val itemBinding: LevelItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(levels: Level,listener: Listener) {
            itemBinding.lvlBtn.text = levels.level.toString()
            itemBinding.lvlBtn.setOnClickListener { listener.onItemClick(levels) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsViewHolder {
        val itemBinding =
            LevelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LevelsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LevelsViewHolder, position: Int) {
        val paymentBean: Level = list[position]
        holder.bind(paymentBean,listener)
    }

    fun add(model: MutableList<Level>) {
        this.list = model
        notifyDataSetChanged()
    }
    interface Listener {
        fun onItemClick(level: Level)
    }

}