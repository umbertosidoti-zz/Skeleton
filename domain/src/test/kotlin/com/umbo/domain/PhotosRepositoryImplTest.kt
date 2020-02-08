package com.umbo.domain

import com.umbo.data.NetworkService
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PhotosRepositoryImplTest {

    @Mock
    lateinit var networkService: NetworkService

    @Mock
    lateinit var storage: PhotosStorage

    lateinit var photosRepositoryImpl: PhotosRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        photosRepositoryImpl = PhotosRepositoryImpl(networkService, storage)
    }
}