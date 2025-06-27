package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2040Test {
    private val sut = LeetCode2040()

    @Test
    fun case1() {
        assertEquals(
            8,
            sut.kthSmallestProduct(
                intArrayOf(2, 5),
                intArrayOf(3, 4),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.kthSmallestProduct(
                intArrayOf(-4, -2, 0, 3),
                intArrayOf(2, 4),
                6
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            -6,
            sut.kthSmallestProduct(
                intArrayOf(-2, -1, 0, 1, 2),
                intArrayOf(-3, -1, 2, 4, 5),
                3
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            -24,
            sut.kthSmallestProduct(
                intArrayOf(-9, -4, 1, 6, 8, 8, 9, 10),
                intArrayOf(-10, -10, -8, -8, 1, 3, 6, 6, 8, 10),
                29
            )
        )
    }
}
