package com.example.newsfeedapp.network

import com.example.newsfeedapp.model.*
import com.example.newsfeedapp.network.RetrofitClientInstance.getNewsFeedApi
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GetStoryUseCaseImpl : GetStoryUseCase {
    override fun getStories(nextPageId: Int): Single<List<StoryItem>> {
        return getNewsFeedApi().getStory(nextPageId)
            .map { it.stories }
            .map {process(it) }
            .subscribeOn(Schedulers.io())

    }

    fun process(it: List<Story>): List<StoryItem> {
        return it.map {  StoryItem(author = it.author,
            body = it.body,
            imageUrl = it.image.url)}
    }
}