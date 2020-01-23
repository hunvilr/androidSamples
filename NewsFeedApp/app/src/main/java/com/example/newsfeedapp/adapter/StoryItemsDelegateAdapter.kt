package com.example.newsfeedapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedapp.R
import com.example.newsfeedapp.model.StoryItem
import kotlinx.android.synthetic.main.layout_story_item.view.*

class StoryItemsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ItemViewHolder
        holder.bind(item as StoryItem)
    }

    inner class ItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_story_item, parent, false)){
        private val image = itemView.imageview
        private val author = itemView.author
        private val body = itemView.body

        fun bind(item: StoryItem) {
            author.text = item.author
            body.text = item.body
            image.loadImage(item.imageUrl)
        }
    }
}
