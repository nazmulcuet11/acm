package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2302Test {
    private val sut = LeetCode2302()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.countSubarrays(intArrayOf(2, 1, 4, 3, 5), 10)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.countSubarrays(intArrayOf(1, 1, 1), 5)
        )
    }
}