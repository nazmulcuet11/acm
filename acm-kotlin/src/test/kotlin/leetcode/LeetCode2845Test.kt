package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2845Test {
    private val sut = LeetCode2845()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.countInterestingSubarrays(listOf(3, 2, 4), 2, 1)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.countInterestingSubarrays(listOf(3, 1, 9, 6), 3, 0)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            5,
            sut.countInterestingSubarrays(listOf(11, 12, 21, 31), 10, 1)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            0,
            sut.countInterestingSubarrays(listOf(2, 4), 7, 2)
        )
    }
}