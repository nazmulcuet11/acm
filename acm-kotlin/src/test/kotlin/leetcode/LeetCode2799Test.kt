package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2799Test {
    private val sut = LeetCode2799()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.countCompleteSubarrays(intArrayOf(1, 3, 1, 2, 2))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            10,
            sut.countCompleteSubarrays(intArrayOf(5, 5, 5, 5))
        )
    }
}