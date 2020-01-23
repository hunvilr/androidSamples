package com.example.newsfeedapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClientInstance {
    private val baseUrl : String = "https://andrewmunn.github.io"
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getNewsFeedApi() : NewsFeedApi {
        return getRetrofitInstance().create(NewsFeedApi::class.java)
    }
}

