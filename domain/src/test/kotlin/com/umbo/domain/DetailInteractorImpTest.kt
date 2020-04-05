package com.umbo.domain

import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.*
import com.umbo.domain.interactor.DetailInteractorImpl
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

    @Mock
    lateinit var navigationPayloadRepository: NavigationPayloadRepository

    lateinit var detailInteractor: DetailInteractorImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        detailInteractor =
            DetailInteractorImpl(photosRepository, navigationPayloadRepository)
    }

    @Test
    fun testReturnErrorIfErrorFromRepository() = runBlocking {
        //Given
        whenever(navigationPayloadRepository.payload).thenReturn(DetailPayload(3))
        whenever(photosRepository.photos(anyBoolean())).thenReturn(Outcome.Error())

        //When
        val result = detailInteractor.findPhoto()

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnErrorIfEmptyRepository() = runBlocking {
        //Given
        whenever(navigationPayloadRepository.payload).thenReturn(DetailPayload(3))
        whenever(photosRepository.photos(anyBoolean())).thenReturn(Outcome.Success(emptyList()))

        //When
        val result = detailInteractor.findPhoto()

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnErrorIfNoItemInRepository() = runBlocking {
        //Given
        whenever(navigationPayloadRepository.payload).thenReturn(DetailPayload(3))
        whenever(photosRepository.photos()).thenReturn(Outcome.Success(listOf(Photo(1, 1, "", "", ""))))

        //When
        val result = detailInteractor.findPhoto()

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnSuccess() = runBlocking {
        //Given
        whenever(navigationPayloadRepository.payload).thenReturn(DetailPayload(3))
        val response = Outcome.Success(listOf(Photo(1, 3, "success", "", "")))
        whenever(photosRepository.photos()).thenReturn(response)

        //When
        val result = detailInteractor.findPhoto()

        //Then
        val photo = (result as? Outcome.Success)?.value
        assertNotNull(photo)
        assertEquals(photo?.title, "success")
    }
}