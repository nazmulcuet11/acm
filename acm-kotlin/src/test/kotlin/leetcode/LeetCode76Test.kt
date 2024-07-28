package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode76Test {
    val sut = LeetCode76()

    @Test
    fun testCaseOne() {
        val expected = "BANC"
        val actual = sut.minWindow ("ADOBECODEBANC", "ABC")
        assertEquals(expected, actual)
    }

    @Test
    fun testCaseTwo() {
        val expected = "a"
        val actual = sut.minWindow ("a", "a")
        assertEquals(expected, actual)
    }

    @Test
    fun testCaseThree() {
        val expected = ""
        val actual = sut.minWindow ("a", "aa")
        assertEquals(expected, actual)
    }
}