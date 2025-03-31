package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2551Test {
    private val sut = LeetCode2551()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.putMarbles(intArrayOf(1, 3, 5, 1), 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.putMarbles(intArrayOf(1, 3), 2)
        )
    }
}