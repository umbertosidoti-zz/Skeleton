package com.umbo.domain

import com.umbo.data.NetworkService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
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

    @Test
    fun testInvalidateCachedData() {
        //Given

        //When
        runBlocking { photosRepositoryImpl.invalidateCachedData() }

        //Then
        Mockito.verify(storage).clearData()
    }


}