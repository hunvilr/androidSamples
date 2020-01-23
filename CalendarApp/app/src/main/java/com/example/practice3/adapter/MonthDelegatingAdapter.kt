package com.example.practice3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3.R
import com.example.practice3.model.ViewItemType
import kotlinx.android.synthetic.main.layout_month.view.*

class MonthDelegatingAdapter :ViewTypeDelegateAdapter{
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return MonthViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItemType) {
        holder as MonthViewHolder
        holder?.itemView.month_id.text = "Febraury"
    }

    inner class MonthViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_month, parent, false))
}