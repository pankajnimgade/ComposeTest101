package com.example.test101.data

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculateTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun addTwoNumber() {
        assertEquals(3, Calculate().addTwoNumber(2, 1))
    }
}