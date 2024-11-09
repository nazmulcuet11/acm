package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3133Test {
    private val sut = LeetCode3133()

    @Test
    fun testCase1() {
        assertEquals(
            6,
            sut.minEnd(3, 4)
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            15,
            sut.minEnd(2, 7)
        )
    }
}