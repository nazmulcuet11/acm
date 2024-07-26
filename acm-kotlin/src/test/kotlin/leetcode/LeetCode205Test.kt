package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeetCode205Test {
    val sut = LeetCode205()

    @Test
    fun testCaseOne() {
        assertTrue(sut.isIsomorphic("egg", "add"))
    }

    @Test
    fun testCaseTwo() {
        assertFalse(sut.isIsomorphic("foo", "bar"))
    }

    @Test
    fun testCaseThree() {
        assertTrue(sut.isIsomorphic("paper", "title"))
    }

    @Test
    fun testCaseFour() {
        assertFalse(sut.isIsomorphic("badc", "baba"))
    }

    @Test
    fun testCaseFive() {
        assertFalse(sut.isIsomorphic("bbbaaaba", "aaabbbba"))
    }
}