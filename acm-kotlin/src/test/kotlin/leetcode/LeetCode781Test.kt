package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode781Test {
    private val sut = LeetCode781()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.numRabbits(intArrayOf(1, 1, 2))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            11,
            sut.numRabbits(intArrayOf(10, 10, 10))
        )
    }
}