package com.example.newsfeedapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedapp.R
import com.example.newsfeedapp.adapter.NewsAdapter
import com.example.newsfeedapp.viewmodel.NewsItemState
import com.example.newsfeedapp.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.news_feed_list.*

class NewsFragment : Fragment() {
    private val newsViewModel by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }
    private val adapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsViewModel.itemState.observe(this, Observer{ manageState(it) })
    }

    private fun manageState(it: NewsItemState?) {
        val state = it ?: return
        when(state) {
            is NewsItemState.Success -> {
                Log.d("NewsFragment", "manageState ${state.items}")
                adapter.addItems(state.items)
            }
            is NewsItemState.Error -> {
                Snackbar.make(items_list, state.message.orEmpty(), Snackbar.LENGTH_INDEFINITE)
                    .setAction("RETRY", {fetchItems(newsViewModel.nextPageId + 1)})
                    .show()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.news_feed_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        items_list.apply {
            val layout = LinearLayoutManager(context)
            this.layoutManager = layout
            clearOnScrollListeners()
            addOnScrollListener(EndlessScrollListener(newsViewModel, layout))
        }

        items_list.adapter = adapter
        fetchItems(newsViewModel.nextPageId)
    }

    fun fetchItems(nextPageId: Int){
        newsViewModel.getNewsItemsList(nextPageId)
    }
}

class EndlessScrollListener(
    val newsViewModel: NewsViewModel,
    val layoutManager: LinearLayoutManager
) : RecyclerView.OnScrollListener() {
    private val visibleThreshold: Int = 2
    var loading = true
    var previousTotal = 0
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
        if(dy > 0) {
            if(loading) {
                if(layoutManager.itemCount > previousTotal) {
                    loading = false
                    previousTotal = layoutManager.itemCount
                }
            }

            if(!loading && (layoutManager.itemCount - recyclerView.childCount) <=
                (layoutManager.findFirstVisibleItemPosition() + visibleThreshold)) {
                onLoadMore()
                loading = true
            }

        }
    }

    fun onLoadMore() {
        Log.d("EndlessScrollListener", "onLoadMore ${newsViewModel.nextPageId}")
        newsViewModel.nextPageId++
        newsViewModel.getNewsItemsList(newsViewModel.nextPageId)
    }
}