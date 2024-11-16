package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode3254Test {
    private val sut = LeetCode3254()

    @Test
    fun testCase1() {
        assertContentEquals(
            intArrayOf(3, 4, -1, -1, -1),
            sut.resultsArray(
                intArrayOf(1, 2, 3, 4, 3, 2, 5),
                3
            )
        )
    }

    @Test
    fun testCase2() {
        assertContentEquals(
            intArrayOf(-1, -1),
            sut.resultsArray(
                intArrayOf(2, 2, 2, 2, 2),
                4
            )
        )
    }

    @Test
    fun testCase3() {
        assertContentEquals(
            intArrayOf(-1, 3, -1, 3, -1),
            sut.resultsArray(
                intArrayOf(3, 2, 3, 2, 3, 2),
                2
            )
        )
    }
}