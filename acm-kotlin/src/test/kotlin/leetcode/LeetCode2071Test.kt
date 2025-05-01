package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2071Test {
    private val sut = LeetCode2071()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.maxTaskAssign(
                intArrayOf(3, 2, 1),
                intArrayOf(0, 3, 3),
                1,
                1
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.maxTaskAssign(
                intArrayOf(5, 4),
                intArrayOf(0, 0, 0),
                1,
                5
            )
        )
    }


    @Test
    fun case3() {
        assertEquals(
            2,
            sut.maxTaskAssign(
                intArrayOf(10, 15, 30),
                intArrayOf(0, 10, 10, 10, 10),
                3,
                10
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            3,
            sut.maxTaskAssign(
                intArrayOf(5, 9, 8, 5, 9),
                intArrayOf(1, 6, 4, 2, 6),
                1,
                5
            )
        )
    }

    @Test
    fun case5() {
        assertEquals(
            1,
            sut.maxTaskAssign(
                intArrayOf(74, 41, 64, 20, 28, 52, 30, 4, 4, 63),
                intArrayOf(38),
                0,
                68
            )
        )
    }
}