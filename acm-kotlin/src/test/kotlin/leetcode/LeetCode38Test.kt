package leetcode

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LeetCode38Test {
    private val sut = LeetCode38()

    @Test
    fun testCaseOne() {
        assertEquals("1", sut.countAndSay(1))
    }

    @Test
    fun testCaseTwo() {
        assertEquals("1211", sut.countAndSay(4))
    }
}