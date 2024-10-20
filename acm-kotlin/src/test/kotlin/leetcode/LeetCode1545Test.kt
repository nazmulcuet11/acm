package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1545Test {
    private val sut = LeetCode1545()

    @Test
    fun testCaseOne() {
        assertEquals('0', sut.findKthBit(3, 1))
    }

    @Test
    fun testCaseTwo() {
        assertEquals('1', sut.findKthBit(4, 11))
    }

    @Test
    fun testCaseThree() {
        assertEquals('1', sut.findKthBit(3, 2))
    }
}