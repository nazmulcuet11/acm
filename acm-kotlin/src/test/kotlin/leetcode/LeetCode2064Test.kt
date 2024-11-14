package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2064Test {
    private val sut = LeetCode2064()

    @Test
    fun testCase1() {
        assertEquals(
            3,
            sut.minimizedMaximum(6, intArrayOf(11, 6))
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            5,
            sut.minimizedMaximum(7, intArrayOf(15, 10, 10))
        )
    }

    @Test
    fun testCase3() {
        assertEquals(
            100000,
            sut.minimizedMaximum(1, intArrayOf(100000))
        )
    }
}