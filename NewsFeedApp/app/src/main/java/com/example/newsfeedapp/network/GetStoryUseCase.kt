package com.example.newsfeedapp.network

import com.example.newsfeedapp.model.StoryItem
import io.reactivex.Single

interface GetStoryUseCase {
    fun getStories(nextPageId: Int) : Single<List<StoryItem>>
}