package com.umbo.domain

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
    fun addition_isCorrect() {

        //Given
        Mockito.`when`(photosRepository.photos())


        //When


        //Then

    }
}