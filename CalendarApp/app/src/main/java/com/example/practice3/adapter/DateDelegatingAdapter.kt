package com.example.practice3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3.R
import com.example.practice3.model.DateItem
import com.example.practice3.model.ViewItemType
import kotlinx.android.synthetic.main.layout_date.view.*

class DateDelegatingAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return DateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItemType) {
        holder as DateViewHolder
        val dateItem = item as DateItem
        holder?.itemView.date_id.text = dateItem.date.toString()
    }

    inner class DateViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_date, parent, false))

}