package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode679Test {
    private val sut = LeetCode679()

    @Test
    fun case1() {
        assertTrue { sut.judgePoint24(intArrayOf(4, 1, 8, 7)) }
    }

    @Test
    fun case2() {
        assertFalse { sut.judgePoint24(intArrayOf(1, 2, 1, 2)) }
    }

    @Test
    fun case3() {
        assertTrue { sut.judgePoint24(intArrayOf(1, 3, 4, 6)) }
    }
}