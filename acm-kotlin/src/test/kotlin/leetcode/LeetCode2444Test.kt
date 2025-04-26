package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2444Test {
    private val sut = LeetCode2444()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.countSubarrays(intArrayOf(1, 3, 5, 2, 7, 5), 1, 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            10,
            sut.countSubarrays(intArrayOf(1, 1, 1, 1), 1, 1)
        )
    }


    @Test
    fun case3() {
        assertEquals(
            1,
            sut.countSubarrays(intArrayOf(4, 3), 3, 3)
        )
    }
}