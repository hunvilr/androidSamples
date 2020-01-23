package com.example.newsfeedapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, viewType: ViewType)
}