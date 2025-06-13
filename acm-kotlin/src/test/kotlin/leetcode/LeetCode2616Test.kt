package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2616Test {
    private val sut = LeetCode2616()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.minimizeMax(intArrayOf(10, 1, 2, 7, 1, 3), 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.minimizeMax(intArrayOf(4, 2, 1, 2), 1)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.minimizeMax(intArrayOf(0, 5, 3, 4), 0)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            0,
            sut.minimizeMax(intArrayOf(4, 1, 3, 3, 0, 4, 3), 1)
        )
    }

    @Test
    fun case5() {
        assertEquals(
            1,
            sut.minimizeMax(intArrayOf(8, 9, 1, 5, 4, 3, 6, 4, 3, 7), 4)
        )
    }

    @Test
    fun case6() {
        assertEquals(
            1,
            sut.minimizeMax(intArrayOf(3, 4, 2, 3, 2, 1, 2), 3)
        )
    }
}