package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1524Test {
    private val sut = LeetCode1524()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.numOfSubarrays(intArrayOf(1, 3, 5))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.numOfSubarrays(intArrayOf(2, 4, 6))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            16,
            sut.numOfSubarrays(intArrayOf(1, 2, 3, 4, 5, 6, 7))
        )
    }
}