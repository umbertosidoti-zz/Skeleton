package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
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
    fun testReturnErrorIfErrorFromRepository() {
        //Given
        runBlocking {
            Mockito.`when`(photosRepository.photos()).thenReturn(Outcome.Error())
        }

        //When
        val result = runBlocking { detailInteractor.findPhoto(3) }

        //Then
        assertTrue(result is Outcome.Error)
    }

    @Test
    fun testReturnErrorIfEmptyRepository() {
        //Given
        runBlocking {
            Mockito.`when`(photosRepository.photos()).thenReturn(Outcome.Success(emptyList()))
        }

        //When
        val result = runBlocking { detailInteractor.findPhoto(3) }

        //Then
        assertTrue(result is Outcome.Error)
    }


    @Test
    fun testReturnErrorIfNoItemInRepository() {

        runBlocking {
            //Given
            Mockito.`when`(photosRepository.photos()).thenReturn(Outcome.Success(listOf(Photo(1, 1, "", "", ""))))

            //When
            val result = runBlocking { detailInteractor.findPhoto(3) }

            //Then
            assertTrue(result is Outcome.Error)
        }
    }

    @Test
    fun testReturnSuccess() {

        runBlocking {

            //Given
            Mockito.`when`(photosRepository.photos())
                .thenReturn(Outcome.Success(listOf(Photo(1, 3, "success", "", ""))))

            //When
            val result = detailInteractor.findPhoto(3)

            //Then
            val photo = (result as? Outcome.Success)?.value
            assertNotNull(photo)
            assertEquals(photo?.title, "success")
        }
    }

}