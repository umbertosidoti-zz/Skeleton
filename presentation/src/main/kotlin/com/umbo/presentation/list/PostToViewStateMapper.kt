package com.umbo.presentation.list


import com.umbo.data.Mapper
import com.umbo.data.Photo

class PostToViewStateMapper: Mapper<Photo, PhotoViewState> {
    override fun map(input: Photo): PhotoViewState {
        return PhotoViewState(input.id, input.user, input.description ?: "empty", input.thumbnailUrl)
    }
}