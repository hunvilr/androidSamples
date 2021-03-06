package com.example.connectorfour.ui.main

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

object Decorations {

    @JvmStatic
    fun spaces(pxBetweenItems: Float, vertical: Boolean = true): RecyclerView.ItemDecoration {
        return if (vertical) {
            SpaceItemDecoration.create(top = pxBetweenItems.toInt(), skipTop = 1)
        } else {
            SpaceItemDecoration.create(left = pxBetweenItems.toInt(), skipTop = 1)
        }
    }

    @JvmStatic
    fun divider(context: Context, orientation: Int): RecyclerView.ItemDecoration {
        return DividerItemDecoration(context, orientation)
    }
}