package com.example.practice3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3.R
import com.example.practice3.model.DayItem
import com.example.practice3.model.ViewItemType
import kotlinx.android.synthetic.main.layout_day.view.*

class DayDelegatingAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return DayViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItemType) {
        holder as DayViewHolder
        val dayItem = item as DayItem
        holder?.itemView.id1.text = dayItem.day
    }

    inner class DayViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_day, parent, false))

}