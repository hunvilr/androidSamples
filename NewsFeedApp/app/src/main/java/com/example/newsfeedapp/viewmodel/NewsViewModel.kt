package com.example.newsfeedapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsfeedapp.model.StoryItem
import com.example.newsfeedapp.network.GetStoryUseCaseImpl
import io.reactivex.android.schedulers.AndroidSchedulers

class NewsViewModel : ViewModel(){
    private val getStoriesUseCaseImpl: GetStoryUseCaseImpl = GetStoryUseCaseImpl()
    var nextPageId = 1
    val itemState: MutableLiveData<NewsItemState> = MutableLiveData()

    fun getNewsItemsList(nextPageId: Int) {
        Log.d("NewsViewModel", "getNewsItemsList ${nextPageId}")
        getStoriesUseCaseImpl.getStories(nextPageId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ handleSuccess(it) }, { handleError(it) })
    }

    private fun handleSuccess(it: List<StoryItem>) {
        itemState.postValue(NewsItemState.Success(it))
    }

    private fun handleError(it: Throwable) {
        itemState.postValue(NewsItemState.Error(it.message))
    }
}