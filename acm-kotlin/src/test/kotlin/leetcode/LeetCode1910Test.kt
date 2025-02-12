package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1910Test {
    private val sut = LeetCode1910()

    @Test
    fun case1() {
        assertEquals(
            "dab",
            sut.removeOccurrences("daabcbaabcbc", "abc")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "ab",
            sut.removeOccurrences("axxxxyyyyb", "xy")
        )
    }
}