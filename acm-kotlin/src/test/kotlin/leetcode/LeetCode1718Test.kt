package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1718Test {
    private val sut = LeetCode1718()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(3, 1, 2, 3, 2),
            sut.constructDistancedSequence(3)
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(5, 3, 1, 4, 3, 5, 2, 4, 2),
            sut.constructDistancedSequence(5)
        )
    }

    @Test
    fun case3() {
        assertContentEquals(
            intArrayOf(13, 11, 12, 8, 6, 4, 9, 10, 1, 4, 6, 8, 11, 13, 12, 9, 7, 10, 3, 5, 2, 3, 2, 7, 5),
            sut.constructDistancedSequence(13)
        )
    }
}