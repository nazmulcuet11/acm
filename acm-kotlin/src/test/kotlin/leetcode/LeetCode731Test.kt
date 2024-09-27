package leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LeetCode731Test {
    @Test
    fun testCaseOne() {
        val sut = LeetCode731()

        assertTrue(sut.book(10, 20))
        assertTrue(sut.book(50, 60))
        assertTrue(sut.book(10, 40))
        assertFalse(sut.book(5, 15))
        assertTrue(sut.book(5, 10))
        assertTrue(sut.book(25, 55))
    }

    @Test
    fun testCaseTwo() {
        val sut = LeetCode731()

        assertTrue(sut.book(26, 35))
        assertTrue(sut.book(26, 32))
        assertFalse(sut.book(25, 32))
        assertTrue(sut.book(18, 26))
        assertTrue(sut.book(40, 45))
        assertTrue(sut.book(19, 26))
        assertTrue(sut.book(48, 50))
        assertTrue(sut.book(1, 6))
        assertTrue(sut.book(46, 50))
        assertTrue(sut.book(11, 18))
    }
}
