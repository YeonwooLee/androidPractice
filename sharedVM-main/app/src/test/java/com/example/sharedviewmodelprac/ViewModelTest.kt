package com.example.sharedviewmodelprac

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.sharedviewmodelprac.model.SharedViewModel
import org.hamcrest.CoreMatchers.any
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Rule

class ViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun setBackSetTest() {
        val viewModel = SharedViewModel()
//        viewModel.backSet.observeForever {}
        viewModel.setBackSet(12)
        assertEquals(12, viewModel.backSet.value)
    }

    @Test
    fun calWholeSetTest(){
        val viewModel = SharedViewModel()
//        viewModel.wholeSet.observeForever {  }
        viewModel.setBackSet(1)
        viewModel.setChestSet(10)
        viewModel.setLeg0(100)
        viewModel.setLeg1(1000)
        viewModel.setLeg2(10000)

        assertEquals(11111,viewModel.wholeSet.value)

    }

}