package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode3264Test {
    private val sut = LeetCode3264()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(8, 4, 6, 5, 6),
            sut.getFinalState(
                intArrayOf(2, 1, 3, 5, 6),
                5,
                2
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(16, 8),
            sut.getFinalState(
                intArrayOf(1, 2),
                3,
                4
            )
        )
    }
}