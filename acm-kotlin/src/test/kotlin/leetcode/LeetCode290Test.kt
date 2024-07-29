package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeetCode290Test {
    val sut = LeetCode290()

    @Test
    fun testCaseOne() {
        assertTrue(sut.wordPattern ("abba", "dog cat cat dog"))
    }

    @Test
    fun testCaseTwo() {
        assertFalse(sut.wordPattern ("abba", "dog cat cat fish"))
    }

    @Test
    fun testCaseThree() {
        assertFalse(sut.wordPattern ("aaaa", "dog cat cat dog"))
    }

    @Test
    fun testCaseFour() {
        assertFalse(sut.wordPattern ("abba", "dog dog dog dog"))
    }
}