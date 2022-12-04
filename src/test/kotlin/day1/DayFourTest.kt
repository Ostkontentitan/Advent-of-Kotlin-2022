package day1

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class DayFourTest {

    @Test
    fun dayFourAgainstSample() {
        val result = dayFour(readTestInput(4, 0))
        assertEquals(2 to 4, result)
    }
}