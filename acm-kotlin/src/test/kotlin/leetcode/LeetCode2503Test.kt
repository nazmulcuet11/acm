package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode2503Test {
    private val sut = LeetCode2503()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(5, 8, 1),
            sut.maxPoints(
                arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 5, 7), intArrayOf(3, 5, 1)),
                intArrayOf(5, 6, 2)
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(0),
            sut.maxPoints(
                arrayOf(intArrayOf(5, 2, 1), intArrayOf(1, 1, 2)),
                intArrayOf(3)
            )
        )
    }
}