package leetcode

import org.junit.jupiter.api.Assertions.*
import utils.sorted
import kotlin.test.Test

class LeetCode49Test {
    private val sut = LeetCode49()

    @Test
    fun testCaseOne() {
        val input = arrayOf("eat","tea","tan","ate","nat","bat")
        val expectedOutput = listOf(
            listOf("bat"),
            listOf("nat","tan"),
            listOf("ate","eat","tea"),
        )
        assertEquals(sorted(expectedOutput), sorted(sut.groupAnagrams(input)))
    }

    @Test
    fun testCaseTwo() {
        val input = arrayOf("")
        val expectedOutput = listOf(
            listOf(""),
        )
        assertEquals(sorted(expectedOutput), sorted(sut.groupAnagrams(input)))
    }

    @Test
    fun testCaseThree() {
        val input = arrayOf("a")
        val expectedOutput = listOf(
            listOf("a"),
        )
        assertEquals(sorted(expectedOutput), sorted(sut.groupAnagrams(input)))
    }
}