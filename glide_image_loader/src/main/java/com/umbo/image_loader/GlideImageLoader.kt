package com.umbo.image_loader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.umbo.data_android.ImageLoader

class GlideImageLoader: ImageLoader {

    override fun load(url: String, imageView: ImageView, placeHolder: Int?) {

        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .placeholder(placeHolder?: R.drawable.placeholder)
            .error(placeHolder?: R.drawable.placeholder)
            .fallback(placeHolder?: R.drawable.placeholder)
            .into(imageView)
    }
}