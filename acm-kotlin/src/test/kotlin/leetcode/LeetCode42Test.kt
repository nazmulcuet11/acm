package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode42Test {
    private val sut = LeetCode42()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            9,
            sut.trap(intArrayOf(4, 2, 0, 3, 2, 5))
        )
    }
}