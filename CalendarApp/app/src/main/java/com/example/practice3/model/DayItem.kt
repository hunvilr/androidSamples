package com.example.practice3.model

data class DayItem(val day: String) : ViewItemType {
    override fun getViewItemType(): Int {
        return AdapterConstants.DAY
    }

}