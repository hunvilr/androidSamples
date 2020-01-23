package com.example.practice3.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3.model.ViewItemType

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItemType)
}