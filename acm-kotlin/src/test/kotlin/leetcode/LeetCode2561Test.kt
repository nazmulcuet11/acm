package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2561Test {
    private val sut = LeetCode2561()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.minCost(
                intArrayOf(4, 2, 2, 2),
                intArrayOf(1, 4, 1, 2)
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.minCost(
                intArrayOf(2, 3, 4, 1),
                intArrayOf(3, 2, 5, 1)
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            48,
            sut.minCost(
                intArrayOf(84, 80, 43, 8, 80, 88, 43, 14, 100, 88),
                intArrayOf(32, 32, 42, 68, 68, 100, 42, 84, 14, 8)
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            8,
            sut.minCost(
                intArrayOf(4, 4, 4, 4, 3),
                intArrayOf(5, 5, 5, 5, 3)
            )
        )
    }

    @Test
    fun case5() {
        assertEquals(
            5,
            sut.minCost(
                intArrayOf(2, 2, 100, 100),
                intArrayOf(3, 3, 200, 200)
            )
        )
    }

    @Test
    fun case6() {
        assertEquals(
            2,
            sut.minCost(
                intArrayOf(1,100,100),
                intArrayOf(1,200,200)
            )
        )
    }
}