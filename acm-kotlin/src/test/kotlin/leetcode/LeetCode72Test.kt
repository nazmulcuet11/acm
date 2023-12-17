package leetcode

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LeetCode72Test {
    private val sut = LeetCode72()

    @Test
    fun testCaseOne() {
        assertEquals(3, sut.minDistance("horse", "ros"))
    }

    @Test
    fun testCaseTwo() {
        assertEquals(5, sut.minDistance("intention", "execution"))
    }
}