package com.umbo.domain

import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.Outcome
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.anyBoolean
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
    fun testReturnError() = runBlocking {
        //Given
        whenever(photosRepository.photos(anyBoolean())).thenReturn(Outcome.Error())

        //When
        val result = listInteractor.photos()

        //Then
        verify(photosRepository).photos(false)
        Assert.assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnSuccess() = runBlocking {
        //Given
        whenever(photosRepository.photos(anyBoolean())).thenReturn(Outcome.Success(emptyList()))

        //When
        val result = listInteractor.photos()

        //Then
        verify(photosRepository).photos(false)
        Assert.assertTrue(result is Outcome.Success)
    }
}