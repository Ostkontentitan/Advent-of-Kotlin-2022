package day1

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class DayTwoTest {

    @Test
    fun dayTwoAgainstSample() {
        val resultOne = dayTwo(readTestInput(2, 0))
        val resultTwo = dayTwo(readTestInput(2, 1))
        assertEquals(15 to 12, resultOne)
        assertEquals(9 to 5, resultTwo)
    }
}