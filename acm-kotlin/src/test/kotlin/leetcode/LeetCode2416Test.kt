package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode2416Test {
    private val sut = LeetCode2416()

    @Test
    fun testCaseOne() {
        assertContentEquals(
            intArrayOf(5, 4, 3, 2),
            sut.sumPrefixScores(arrayOf("abc", "ab", "bc", "b"))
        )
    }

    @Test
    fun testCaseTwo() {
        assertContentEquals(
            intArrayOf(4),
            sut.sumPrefixScores(arrayOf("abcd"))
        )
    }
}