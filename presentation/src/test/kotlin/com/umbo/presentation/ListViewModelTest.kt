package com.umbo.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.umbo.data.Destination
import com.umbo.data.Outcome
import com.umbo.data.Photo
import com.umbo.data.ListInteractor
import com.umbo.presentation.list.ListViewModel
import com.umbo.presentation.list.PostToViewStateMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var viewModel: ListViewModel

    @Mock
    lateinit var listInteractor: ListInteractor

    lateinit var mapper: PostToViewStateMapper

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mapper = PostToViewStateMapper()
        viewModel = ListViewModel(Dispatchers.IO, listInteractor, mapper)
    }

    @Test
    fun testInteractorReturnError() {
        //Given
        runBlocking {
            whenever(listInteractor.photos()).thenReturn(Outcome.Error())
        }

        //Given
        val outcome = viewModel.liveData.getOrAwaitValue()

        //Then
        Assert.assertTrue(outcome is Outcome.Error)
    }

    @Test
    fun testInteractorReturnSuccess() {
        //Given
        runBlocking {
            whenever(listInteractor.photos()).thenReturn(Outcome.Success(listOf(Photo(1,1,"success","",""))))
        }

        //Given
        val outcome = viewModel.liveData.getOrAwaitValue()
        val value = (outcome as? Outcome.Success)?.value

        //Then
        Assert.assertTrue(outcome is Outcome.Success)
        Assert.assertTrue(value?.get(0)?.title ?: "" == "success")
    }

    @Test
    fun testClickItem() {
        //Given
        runBlocking {
            whenever(listInteractor.photos()).thenReturn(Outcome.Success(listOf(Photo(1,1,"success","",""))))
        }

        //Given
        viewModel.onItemClick(1)
        val value = viewModel.navigationAction.getOrAwaitValue()

        //Then
        Assert.assertTrue((value.payload as? Int) == 1 )
        Assert.assertTrue(value.destination == Destination.DETAIL)
    }
}