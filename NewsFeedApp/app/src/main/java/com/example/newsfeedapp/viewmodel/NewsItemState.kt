package com.example.newsfeedapp.viewmodel

import com.example.newsfeedapp.model.StoryItem

sealed class NewsItemState {
    class Success(val items: List<StoryItem>) : NewsItemState()
    class Error(val message: String?) : NewsItemState()

}