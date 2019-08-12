package com.umbo.skeleton.list

import com.umbo.data.Photo
import com.umbo.skeleton.core.Mapper

class PostToViewStateMapper: Mapper<Photo, PhotoViewState> {
    override fun map(input: Photo): PhotoViewState {
        return PhotoViewState(input.id, input.title, input.thumbnailUrl)
    }
}