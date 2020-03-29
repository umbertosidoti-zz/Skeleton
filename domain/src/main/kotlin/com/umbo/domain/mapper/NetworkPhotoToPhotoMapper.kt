package com.umbo.domain.mapper

import com.umbo.data.Mapper
import com.umbo.data.Photo
import com.umbo.network_interface.NetworkPhoto

class NetworkPhotoToPhotoMapper : Mapper<NetworkPhoto, Photo?> {
    override fun map(input: NetworkPhoto): Photo? {
        val id = input.id ?: return null
        val albumId = input.albumId ?: return null
        val title = input.title ?: ""
        val thumb = input.thumbnailUrl ?: ""
        val url = input.url ?: ""
        return Photo(albumId, id, title, url, thumb)
    }
}