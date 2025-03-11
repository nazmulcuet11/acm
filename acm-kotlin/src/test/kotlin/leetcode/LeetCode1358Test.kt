package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1358Test {
    private val sut = LeetCode1358()

    @Test
    fun case1() {
        assertEquals(
            10,
            sut.numberOfSubstrings("abcabc")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.numberOfSubstrings("aaacb")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.numberOfSubstrings("abc")
        )
    }
}