package com.umbo.domain

import com.umbo.data.Outcome
import com.umbo.data.Photo
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PhotosStorageImplTest {

    lateinit var photosStorage: PhotosStorageImpl

    @Before
    fun setUp() {
        photosStorage = PhotosStorageImpl()
    }

    @Test
    fun testEmptyData() = runBlocking {
        //Given

        //When
        val outcome = photosStorage.photos

        //Then
        assertTrue(outcome is Outcome.Success)
        val result = (outcome as? Outcome.Success)?.value
        assertNotNull(result)
        assertTrue(result?.size == 0)
    }

    @Test
    fun testData() = runBlocking {
        //Given
        photosStorage.replacePhotos(listOf(Photo(1, 1, "", "", "")))

        //When
        val outcome = photosStorage.photos

        //Then
        assertTrue(outcome is Outcome.Success)
        val result = (outcome as? Outcome.Success)?.value
        assertNotNull(result)
        assertTrue(result?.size == 1)
        assertTrue(result?.get(0)?.id ?: 0 == 1)
    }

    @Test
    fun testCleanData() = runBlocking {
        //Given
        photosStorage.replacePhotos(listOf(Photo(1, 1, "", "", "")))

        //When
        photosStorage.clearData()
        val outcome = photosStorage.photos

        //Then
        assertTrue(outcome is Outcome.Success)
        val result = (outcome as? Outcome.Success)?.value
        assertNotNull(result)
        assertTrue(result?.size == 0)
    }
}