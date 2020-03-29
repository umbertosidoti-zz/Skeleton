package com.umbo.domain

import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.data.PhotosStorage
import com.umbo.domain.repository.PhotosRepositoryImpl
import com.umbo.network.data.NetworkService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PhotosRepositoryImplTest {

    @Mock
    lateinit var networkService: NetworkService

    @Mock
    lateinit var storage: PhotosStorage

    lateinit var photosRepository: PhotosRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        photosRepository = PhotosRepositoryImpl(
            networkService,
            storage
        )
    }

    @Test
    fun testPhotosFromCacheErrorEndNetworkError() = runBlocking {
        //Given
        whenever(storage.photos).thenReturn(Outcome.Error())
        whenever(networkService.photos()).thenReturn(Outcome.Error())

        //When
        val photos = photosRepository.photos()

        //Then
        verify(storage).photos
        verify(networkService).photos()
        assertTrue(photos is Outcome.Error)
    }

    @Test
    fun testPhotosFromCacheEmptyEndNetworkError() = runBlocking {
        //Given
        whenever(storage.photos).thenReturn(Outcome.Success(emptyList()))
        whenever(networkService.photos()).thenReturn(Outcome.Error())

        //When
        val photos = photosRepository.photos()

        //Then
        verify(storage).photos
        verify(networkService).photos()
        assertTrue(photos is Outcome.Error)
    }

    @Test
    fun testPhotosFromCache() = runBlocking {
        //Given
        whenever(storage.photos).thenReturn(Outcome.Success(listOf(Photo(1,1,"","",""))))
        whenever(networkService.photos()).thenReturn(Outcome.Error())

        //When
        val photos = photosRepository.photos()

        //Then
        verify(storage).photos
        verify(networkService, never()).photos()
        assertTrue(photos is Outcome.Success)
    }

    @Test
    fun testPhotosFromNetworkWithError() = runBlocking {
        //Given
        whenever(storage.photos).thenReturn(Outcome.Success(listOf(Photo(1,1,"","",""))))
        whenever(networkService.photos()).thenReturn(Outcome.Error())

        //When
        val photos = photosRepository.photos(false)

        //Then
        verify(storage, never()).photos
        verify(networkService).photos()
        assertTrue(photos is Outcome.Error)
    }

    @Test
    fun testPhotosFromNetwork() = runBlocking {
        //Given
        whenever(storage.photos).thenReturn(Outcome.Success(listOf(Photo(1,1,"","",""))))
        whenever(networkService.photos()).thenReturn(Outcome.Success(emptyList()))

        //When
        val photos = photosRepository.photos(false)

        //Then
        verify(storage, never()).photos
        verify(networkService).photos()
        assertTrue(photos is Outcome.Success)
    }
}