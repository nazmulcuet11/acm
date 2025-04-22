package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2338Test {
    private val sut = LeetCode2338()

    @Test
    fun case1() {
        assertEquals(
            10,
            sut.idealArrays(2, 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            11,
            sut.idealArrays(5, 3)
        )
    }
}