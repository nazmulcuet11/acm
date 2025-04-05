package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1863Test {
    private val sut = LeetCode1863()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.subsetXORSum(intArrayOf(1, 3))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            28,
            sut.subsetXORSum(intArrayOf(5, 1, 6))
        )
    }
}