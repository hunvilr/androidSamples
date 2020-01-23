package com.example.newsfeedapp.network

import com.example.newsfeedapp.model.NewsFeedResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsFeedApi {

    @GET("/newsfeed/page{nextPageId}.json")
    fun getStory(@Path("nextPageId") nextPageId: Int) : Single<NewsFeedResponse>
}