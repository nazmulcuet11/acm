package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode930Test {
    private val sut = LeetCode930()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            15,
            sut.numSubarraysWithSum(intArrayOf(0, 0, 0, 0, 0), 0)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            27,
            sut.numSubarraysWithSum(intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0), 0)
        )
    }
}