package com.umbo.data_android

import android.graphics.drawable.Drawable
import android.widget.ImageView

interface ImageLoader {
    fun load(url: String, imageView: ImageView, placeHolder: Int? = null)
}