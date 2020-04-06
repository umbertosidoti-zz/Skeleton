package com.umbo.domain.mapper

import com.umbo.data.Mapper
import com.umbo.data.Photo
import com.umbo.network_interface.NetworkPhoto

class NetworkPhotoToPhotoMapper : Mapper<NetworkPhoto, Photo?> {
    override fun map(input: NetworkPhoto): Photo? {
        val id = input.id ?: return null
        val width = input.width ?: return null
        val height = input.height ?: return null
        val title = input.description ?: ""
        val thumb = input.urls?.thumb ?: ""
        val url = input.urls?.small ?: ""
        return Photo(id, width, height, title, url, thumb)
    }
}