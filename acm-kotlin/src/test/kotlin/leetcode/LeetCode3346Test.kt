package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3346Test {
    private val sut = LeetCode3346()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.maxFrequency(
                intArrayOf(1, 4, 5),
                1,
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.maxFrequency(
                intArrayOf(5, 11, 20, 20),
                5,
                1
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            2,
            sut.maxFrequency(
                intArrayOf(88, 53),
                27,
                2
            )
        )
    }
}