package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2762Test {
    private val sut = LeetCode2762()

    @Test
    fun case1() {
        assertEquals(
            8,
            sut.continuousSubarrays(intArrayOf(5, 4, 2, 4))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            6,
            sut.continuousSubarrays(intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            55,
            sut.continuousSubarrays(intArrayOf(42, 41, 42, 43, 43, 42, 43, 42, 42, 41))
        )
    }
}