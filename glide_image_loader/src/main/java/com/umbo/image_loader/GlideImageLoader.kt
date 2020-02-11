package com.umbo.image_loader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.umbo.data_android.ImageLoader

class GlideImageLoader: ImageLoader {

    private val TIMEOUT = 10000

    override fun load(url: String, imageView: ImageView, placeHolder: Int?) {
        Glide.with(imageView).applyDefaultRequestOptions(RequestOptions().timeout(TIMEOUT))
            .load(url)
            .centerCrop()
            .placeholder(placeHolder?: R.drawable.placeholder)
            .error(placeHolder?: R.drawable.placeholder)
            .fallback(placeHolder?: R.drawable.placeholder)
            .into(imageView)
    }
}