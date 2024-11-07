package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode1593Test {
    private val sut = LeetCode1593()

    @Test
    fun testCaseOne() {
        assertEquals(
            5,
            sut.maxUniqueSplit("ababccc")
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            2,
            sut.maxUniqueSplit("aba")
        )
    }

    @Test
    fun testCaseThree() {
        assertEquals(
            1,
            sut.maxUniqueSplit("aa")
        )
    }
}