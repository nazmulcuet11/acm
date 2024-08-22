package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode52Test {
    val sut = LeetCode52()

    @Test
    fun testCase1() {
        assertEquals(2, sut.totalNQueens(4))
    }

    @Test
    fun testCase2() {
        assertEquals(1, sut.totalNQueens(1))
    }
}