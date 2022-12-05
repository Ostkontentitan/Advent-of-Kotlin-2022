package day1

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class DayFiveTest {

    @Test
    fun dayFiveAgainstSample() {
        val result = dayFive(readTestInput(5, 0))
        assertEquals("CMZ" to "MCD", result)
    }
}