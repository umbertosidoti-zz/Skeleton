package com.umbo.data

import android.widget.ImageView

interface ImageLoader {
    fun load(url: String, imageView: ImageView, placeHolder: Int? = null)
}