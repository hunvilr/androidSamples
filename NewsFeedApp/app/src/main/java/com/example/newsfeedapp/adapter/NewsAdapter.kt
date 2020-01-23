package com.example.newsfeedapp.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedapp.model.StoryItem
import java.util.*

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = ArrayList<ViewType>()
    private val delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() : Int {
            return AdapterConstants.LOADING
        }
    }

    init {
        initDelegatingAdapter()
        items = ArrayList()
        items.add(loadingItem)
    }

    private fun initDelegatingAdapter() {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.STORYITEM, StoryItemsDelegateAdapter())
    }

    private fun retrieveDelegatingAdapter(viewType: Int) : ViewTypeDelegateAdapter {
        if(viewType == AdapterConstants.LOADING) {
            return LoadingDelegateAdapter()
        }
        return StoryItemsDelegateAdapter()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val type = delegateAdapters.get(viewType)
        if(type != null) {
            return type.onCreateViewHolder(parent)
        }
        return retrieveDelegatingAdapter(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = delegateAdapters.get(getItemViewType(position))
        if(type != null) {
            return type.onBindViewHolder(holder, items[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    fun addItems(list: List<StoryItem>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        //Add all items and then the loading
        items.addAll(list)
        if(list.isNotEmpty()) {
            items.add(loadingItem)  // Page 5 was coming empty
        }
        notifyItemRangeChanged(initPosition, items.size)
    }
}