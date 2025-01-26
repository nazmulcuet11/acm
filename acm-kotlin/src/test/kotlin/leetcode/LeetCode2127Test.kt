package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2127Test {
    private val sut = LeetCode2127()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.maximumInvitations(intArrayOf(2, 2, 1, 2))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.maximumInvitations(intArrayOf(1, 2, 0))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            4,
            sut.maximumInvitations(intArrayOf(3, 0, 1, 4, 1))
        )
    }

    @Test
    fun case4() {
        assertEquals(
            2,
            sut.maximumInvitations(intArrayOf(1, 0))
        )
    }

    @Test
    fun case5() {
        assertEquals(
            11,
            sut.maximumInvitations(intArrayOf(1, 0, 3, 2, 5, 6, 7, 4, 9, 8, 11, 10, 11, 12, 10))
        )
    }
}