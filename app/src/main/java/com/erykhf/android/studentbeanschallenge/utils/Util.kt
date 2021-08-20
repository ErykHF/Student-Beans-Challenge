package com.erykhf.android.studentbeanschallenge.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(uri: String){
    Glide.with(this.context)
//        .asBitmap()
//        .apply(RequestOptions.circleCropTransform())
        .load(uri)
        .into(this)
}