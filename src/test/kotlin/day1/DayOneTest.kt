package day1

import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class DayOneTest {

    @Test
    fun dayOneAgainstSample() {
        val results = dayOne(readTestInput(1))
        assertEquals(24000 to 45000, results)
    }
}