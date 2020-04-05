package com.umbo.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.DetailInteractor
import com.umbo.data.Navigator
import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.presentation.detail.DetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

    @ExperimentalCoroutinesApi
    @get:Rule
    var rule2 = CoroutineTestRule()


    lateinit var viewModel: DetailViewModel

    @Mock
    lateinit var detailInteractor: DetailInteractor

    @Mock
    lateinit var navigator: Navigator

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DetailViewModel(Dispatchers.IO, navigator, detailInteractor)
    }

    @Test
    fun testSuccess() {
        //Given

        runBlocking {
            whenever(detailInteractor.findPhoto()).thenReturn(Outcome.Success(Photo(1, 1, "success", "", "")))
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

        runBlocking {
            whenever(detailInteractor.findPhoto()).thenReturn(Outcome.Error())
        }

        //Given
        val outcome = viewModel.liveData.getOrAwaitValue()

        //Then
        assertTrue(outcome is Outcome.Error)
    }

}