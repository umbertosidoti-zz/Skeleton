package com.umbo.skeleton.list

import android.net.Uri

data class PhotoViewState(val id: Int, val title: String, val url: String)

data class ListViewState(val error: Boolean, val photos: List<PhotoViewState>)