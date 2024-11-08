package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1829Test {
    private val sut = LeetCode1829()

    @Test
    fun testCase1() {
        assertContentEquals(
            intArrayOf(0, 3, 2, 3),
            sut.getMaximumXor(intArrayOf(0, 1, 1, 3), 2)
        )
    }

    @Test
    fun testCase2() {
        assertContentEquals(
            intArrayOf(5, 2, 6, 5),
            sut.getMaximumXor(intArrayOf(2, 3, 4, 7), 3)
        )
    }

    @Test
    fun testCase3() {
        assertContentEquals(
            intArrayOf(4, 3, 6, 4, 6, 7),
            sut.getMaximumXor(intArrayOf(0, 1, 2, 2, 5, 7), 3)
        )
    }
}