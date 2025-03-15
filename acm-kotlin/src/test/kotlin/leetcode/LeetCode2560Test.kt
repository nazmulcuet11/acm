package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2560Test {
    private val sut = LeetCode2560()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.minCapability(intArrayOf(2, 3, 5, 9), 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.minCapability(intArrayOf(2, 7, 9, 3, 1), 2)
        )
    }
}