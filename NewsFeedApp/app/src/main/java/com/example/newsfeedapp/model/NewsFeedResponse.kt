package com.example.newsfeedapp.model

data class NewsFeedResponse(
    val nextPageId: String?,
    val stories: List<Story>
)
data class ImageObj(
    val url: String,
    val width: Int,
    val height: Int
)

data class Story(
    val id: String,
    val body: String,
    val author: String,
    val image: ImageObj
)