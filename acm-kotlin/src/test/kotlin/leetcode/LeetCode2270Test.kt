package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2270Test {
    private val sut = LeetCode2270()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.waysToSplitArray(intArrayOf(10, 4, -8, 7))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.waysToSplitArray(intArrayOf(2, 3, 1, 0))
        )
    }
}