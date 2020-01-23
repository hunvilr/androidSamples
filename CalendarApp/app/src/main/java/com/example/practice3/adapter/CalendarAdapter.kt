package com.example.practice3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3.R
import com.example.practice3.model.AdapterConstants
import com.example.practice3.model.DateItem
import com.example.practice3.model.DayItem
import com.example.practice3.model.ViewItemType

class CalendarAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // Span count indicates how many columns or rows you have divided
    // For the 0th item how many spans you need, we need the entire match parent, so set it same as NUMBER_OF_COLUMNS span count
    val spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            var spanSize = 0
            when(position) {
                0 -> spanSize = 7
                else -> spanSize = 1
            }
            return spanSize
        }
    }

    private val delegatingAdapterItems = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private var adapterItems = arrayListOf<ViewItemType>()
    private val monthItem = object : ViewItemType {
        override fun getViewItemType(): Int {
            return AdapterConstants.MONTH
        }
    }

    private val dayItem = object : ViewItemType {
        override fun getViewItemType(): Int {
            return AdapterConstants.DAY
        }
    }

    init {
        delegatingAdapterItems.put(AdapterConstants.MONTH, MonthDelegatingAdapter())
        delegatingAdapterItems.put(AdapterConstants.DAY, DayDelegatingAdapter())
        delegatingAdapterItems.put(AdapterConstants.DATE, DateDelegatingAdapter())

        adapterItems.add(monthItem)
        val days = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
        for(i in days) {
            adapterItems.add(DayItem(i))
        }

        for (i in 1..3) {
            adapterItems.add(DateItem(""))
        }

        for (i in 1..31) {
            adapterItems.add(DateItem(i.toString()))
        }
    }

    override fun getItemCount(): Int {
        return adapterItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = delegatingAdapterItems.get(viewType)
        if(viewHolder != null) {
            return viewHolder.onCreateViewHolder(parent)
        }
        return RowColumnViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = delegatingAdapterItems.get(getItemViewType(position))
        if(viewHolder != null) {
            return viewHolder.onBindViewHolder(holder, adapterItems[position])
        }
    }

    inner class RowColumnViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_date, parent, false))


    override fun getItemViewType(position: Int): Int {
       return adapterItems[position].getViewItemType()
    }
}