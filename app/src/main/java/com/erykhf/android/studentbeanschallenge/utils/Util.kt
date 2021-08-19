package com.erykhf.android.studentbeanschallenge.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadImage(uri: String, error: Int){
    Glide.with(this.context)
        .load(uri)
        .error(error)
        .into(this)
}