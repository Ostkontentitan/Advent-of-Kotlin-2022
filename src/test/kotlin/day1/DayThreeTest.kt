package day1

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class DayThreeTest {

    @Test
    fun dayThreeAgainstSample() {
        val result = dayThree(readTestInput(3, 0))
        assertEquals(157 to 70, result)
    }
}