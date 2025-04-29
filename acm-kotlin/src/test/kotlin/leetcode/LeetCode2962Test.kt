package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2962Test {
    private val sut = LeetCode2962()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.countSubarrays(intArrayOf(1, 3, 2, 3, 3), 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.countSubarrays(intArrayOf(1, 4, 2, 1), 3)
        )
    }
}