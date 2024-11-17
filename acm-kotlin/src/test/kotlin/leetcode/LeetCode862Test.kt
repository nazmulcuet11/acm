package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode862Test {
    private val sut = LeetCode862()

    @Test
    fun testCase1() {
        assertEquals(
            1,
            sut.shortestSubarray(intArrayOf(1), 1)
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            -1,
            sut.shortestSubarray(intArrayOf(1, 2), 4)
        )
    }

    @Test
    fun testCase3() {
        assertEquals(
            3,
            sut.shortestSubarray(intArrayOf(2, -1, 2), 3)
        )
    }


    @Test
    fun testCase4() {
        assertEquals(
            3,
            sut.shortestSubarray(intArrayOf(-28, 81, -20, 28, -29), 89)
        )
    }

    @Test
    fun testCase5() {
        assertEquals(
            1,
            sut.shortestSubarray(intArrayOf(44, -25, 75, -50, -38, -42, -32, -6, -40, -47), 19)
        )
    }

    @Test
    fun testCase6() {
        assertEquals(
            2,
            sut.shortestSubarray(intArrayOf(75,-32,50, 32, 97), 129)
        )
    }
}