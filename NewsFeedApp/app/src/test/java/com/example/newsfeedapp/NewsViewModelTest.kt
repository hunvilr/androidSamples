package com.example.newsfeedapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsfeedapp.model.NewsFeedResponse
import com.example.newsfeedapp.network.NewsFeedApi
import com.example.newsfeedapp.viewmodel.NewsItemState
import com.example.newsfeedapp.viewmodel.NewsViewModel
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.ArgumentMatchers.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NewsViewModelTest {

    private val api = mockk<NewsFeedApi>()
    @get:Rule
    var rule : TestRule = InstantTaskExecutorRule()

    var itemsViewModel = NewsViewModel()

    @Before
    fun setup() {
        every { api.getStory(anyInt()) }.returns(Single.just(NewsFeedResponse(anyString(), listOf())))
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }


    @Test
    fun `Success - check response is not null`() {
        // call
        itemsViewModel.getNewsItemsList(anyInt())

        // assert
        val actualValue = itemsViewModel.itemState.value
        assertNotNull(actualValue)
        assertTrue(actualValue is NewsItemState)
    }

    @Test
    fun `Success - check response has one item via single`() {
        val newsFeedResponse =  NewsFeedResponse(anyString(), listOf())

        every { api.getStory(anyInt()) }.returns(Single.just(newsFeedResponse))

        // call
        itemsViewModel.getNewsItemsList(1)

        val value = itemsViewModel.itemState.value
        assertNotNull(value)
        assertTrue(value is NewsItemState.Success)


        val item = value as NewsItemState.Success
        assertEquals(value.items[0].author, item.items[0].author)
        assertEquals(value.items[0].body, item.items[0].body)
        assertEquals(value.items[0].imageUrl, item.items[0].imageUrl)
    }
}
