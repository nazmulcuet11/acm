package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3208Test {
    private val sut = LeetCode3208()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.numberOfAlternatingGroups(
                intArrayOf(0, 1, 0, 1, 0),
                3
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.numberOfAlternatingGroups(
                intArrayOf(0, 1, 0, 0, 1, 0, 1),
                6
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.numberOfAlternatingGroups(
                intArrayOf(1, 1, 0, 1),
                4
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            4,
            sut.numberOfAlternatingGroups(
                intArrayOf(0, 1, 0, 1),
                3
            )
        )
    }

    @Test
    fun case5() {
        assertEquals(
            3,
            sut.numberOfAlternatingGroups(
                intArrayOf(0, 1, 0, 0, 1),
                3
            )
        )
    }
}