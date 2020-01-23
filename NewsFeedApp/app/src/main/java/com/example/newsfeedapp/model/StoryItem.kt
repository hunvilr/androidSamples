package com.example.newsfeedapp.model

import com.example.newsfeedapp.adapter.AdapterConstants
import com.example.newsfeedapp.adapter.ViewType

data class StoryItem(
    val author: String,
    val body: String,
    val imageUrl: String
) : ViewType {
    override fun getViewType(): Int {
        return AdapterConstants.STORYITEM
    }

}