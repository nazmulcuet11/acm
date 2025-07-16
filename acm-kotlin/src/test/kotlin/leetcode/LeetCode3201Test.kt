package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode3201Test {

    private val sut = LeetCode3201()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.maximumLength(intArrayOf(1,2,3,4))
        )
    }

    @Test
    fun cas2() {
        assertEquals(
            6,
            sut.maximumLength(intArrayOf(1,2,1,1,2,1,2))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            2,
            sut.maximumLength(intArrayOf(1, 3))
        )
    }
}
