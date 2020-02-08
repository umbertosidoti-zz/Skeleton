package com.umbo.domain

import com.umbo.data.Outcome
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ListInteractorImplTest {

    @Mock
    lateinit var photosRepository: PhotosRepository

    lateinit var listInteractor: ListInteractorImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        listInteractor = ListInteractorImpl((photosRepository))
    }

    @Test
    fun testCallCleanCache() {
        //Given

        //When
        val result = runBlocking { listInteractor.photos() }

        //Then
        verify(photosRepository).invalidateCachedData()
        verify(photosRepository).photos()
    }

    @Test
    fun testReturnError() {
        //Given
        Mockito.`when`(photosRepository.photos()).thenReturn(Outcome.Error())

        //When
        val result = runBlocking { listInteractor.photos() }

        //Then
        Assert.assertTrue(result is Outcome.Error)
    }


    @Test
    fun testReturnSuccess() {
        //Given
        Mockito.`when`(photosRepository.photos()).thenReturn(Outcome.Success(emptyList()))

        //When
        val result = runBlocking { listInteractor.photos() }

        //Then
        Assert.assertTrue(result is Outcome.Success)
    }
}