package day1

import day6.daySix
import org.junit.jupiter.api.Test
import readTestInput
import kotlin.test.assertEquals

class DaySixTest {

    @Test
    fun daySixAgainstSample() {
        val result1 = daySix(readTestInput(6, 0))
        val result2 = daySix(readTestInput(6, 1))
        val result3 = daySix(readTestInput(6, 2))
        val result4 = daySix(readTestInput(6, 3))
        val result5 = daySix(readTestInput(6, 4))

        assertEquals(7 to 19, result1)
        assertEquals(5 to 23, result2)
        assertEquals(6 to 23, result3)
        assertEquals(10 to 29, result4)
        assertEquals(11 to 26, result5)
    }
}