package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2707Test {
    private val sut = LeetCode2707()

    @Test
    fun testCaseOne() {
        assertEquals(
            1,
            sut.minExtraChar("leetscode", arrayOf("leet","code","leetcode"))
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            3,
            sut.minExtraChar("sayhelloworld", arrayOf("hello","world"))
        )
    }
}