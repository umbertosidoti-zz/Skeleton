package com.umbo.domain

import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.Outcome
import com.umbo.data.Photo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailInteractorImpTest {

    @Mock
    lateinit var photosRepository: PhotosRepository

    lateinit var detailInteractor: DetailInteractorImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        detailInteractor = DetailInteractorImpl((photosRepository))
    }

    @Test
    fun testReturnErrorIfErrorFromRepository() = runBlocking {
        //Given
        whenever(photosRepository.photos(anyBoolean())).thenReturn(Outcome.Error())

        //When
        val result = detailInteractor.findPhoto(3)

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnErrorIfEmptyRepository() = runBlocking {
        //Given
        whenever(photosRepository.photos(anyBoolean())).thenReturn(Outcome.Success(emptyList()))

        //When
        val result = detailInteractor.findPhoto(3)

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnErrorIfNoItemInRepository() = runBlocking {
        //Given
        whenever(photosRepository.photos()).thenReturn(Outcome.Success(listOf(Photo(1, 1, "", "", ""))))

        //When
        val result = detailInteractor.findPhoto(3)

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnSuccess() = runBlocking {
        //Given
        val response = Outcome.Success(listOf(Photo(1, 3, "success", "", "")))
        whenever(photosRepository.photos()).thenReturn(response)

        //When
        val result = detailInteractor.findPhoto(3)

        //Then
        val photo = (result as? Outcome.Success)?.value
        assertNotNull(photo)
        assertEquals(photo?.title, "success")
    }
}