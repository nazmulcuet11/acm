package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3105Test {
    private val sut = LeetCode3105()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.longestMonotonicSubarray(
                intArrayOf(1, 4, 3, 3, 2)
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.longestMonotonicSubarray(
                intArrayOf(3, 3, 3, 3)
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            3,
            sut.longestMonotonicSubarray(
                intArrayOf(3, 2, 1)
            )
        )
    }
}