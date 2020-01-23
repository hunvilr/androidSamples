package com.example.practice3.model

data class DateItem(val date: String) : ViewItemType {
    override fun getViewItemType(): Int {
        return AdapterConstants.DATE
    }

}