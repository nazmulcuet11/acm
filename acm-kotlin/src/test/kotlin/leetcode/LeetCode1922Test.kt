package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1922Test {
    private val sut = LeetCode1922()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.countGoodNumbers(1)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            400,
            sut.countGoodNumbers(4)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            564908303,
            sut.countGoodNumbers(50)
        )
    }
}