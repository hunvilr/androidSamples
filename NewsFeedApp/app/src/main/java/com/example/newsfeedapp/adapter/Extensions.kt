package com.example.newsfeedapp.adapter

import android.widget.ImageView
import com.example.newsfeedapp.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {
    if(url.isNullOrEmpty()) {
        Picasso.with(context)
            .load(R.drawable.ic_launcher_background)
            .into(this)
    } else {
        Picasso.with(context)
            .load(url)
            .into(this)
    }
}