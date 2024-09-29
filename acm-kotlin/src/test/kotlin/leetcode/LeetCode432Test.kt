package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode432Test {
    @Test
    fun testCaseOne() {
        val sut = LeetCode432.AllOne()

        sut.inc("hello")
        sut.inc("goodbye")
        sut.inc("hello")
        sut.inc("hello")
        assertEquals("hello", sut.getMaxKey())
        sut.inc("leet")
        sut.inc("code")
        sut.inc("leet")
        sut.dec("hello")
        sut.inc("leet")
        sut.inc("code")
        sut.inc("code")
        assertEquals("leet", sut.getMaxKey())
    }

    @Test
    fun testCaseTwo() {
        val sut = LeetCode432.AllOne()

        sut.inc("a")
        sut.inc("b")
        sut.inc("b")
        sut.inc("c")
        sut.inc("c")
        sut.inc("c")
        sut.dec("b")
        sut.dec("b")
        assertEquals("a", sut.getMinKey())
        sut.dec("a")
        assertEquals("c", sut.getMaxKey())
        assertEquals("c", sut.getMinKey())
    }

    @Test
    fun testCaseThree() {
        val sut = LeetCode432.AllOne()

        sut.inc("a")
        sut.inc("b")
        sut.inc("c")
        sut.inc("d")
        sut.inc("a")
        sut.inc("b")
        sut.inc("c")
        sut.inc("d")
        sut.inc("c")
        sut.inc("d")
        sut.inc("d")
        sut.inc("a")
        assertEquals("b", sut.getMinKey())
    }
}