package com.umbo.skeleton

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.domain.DetailInteractor
import com.umbo.skeleton.detail.DetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class DetailViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var viewModel: DetailViewModel

    @Mock
    lateinit var detailInteractor: DetailInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DetailViewModel(Dispatchers.IO, detailInteractor)
    }

    @Test
    fun testSuccess() {
        //Given
        viewModel.payload = 1

        runBlocking {
            whenever(detailInteractor.findPhoto(1)).thenReturn(Outcome.Success(Photo(1, 1, "success", "", "")))
        }

        //Given
        val outcome = viewModel.liveData.getOrAwaitValue()
        val value = (outcome as? Outcome.Success)?.value

        //Then
        assertTrue(outcome is Outcome.Success)
        assertTrue(value?.title == "success")
    }

    @Test
    fun testErrorInteractor() {
        //Given
        viewModel.payload = 1

        runBlocking {
            whenever(detailInteractor.findPhoto(1)).thenReturn(Outcome.Error())
        }

        //Given
        val outcome = viewModel.liveData.getOrAwaitValue()

        //Then
        assertTrue(outcome is Outcome.Error)
    }

    @Test
    fun testErrorNoPayload() {
        //Given
        viewModel.payload = null

        runBlocking {
            whenever(detailInteractor.findPhoto(1)).thenReturn(Outcome.Success(Photo(1, 1, "success", "", "")))
        }

        //Given
        val outcome = viewModel.liveData.getOrAwaitValue()

        //Then
        assertTrue(outcome is Outcome.Error)
    }
}