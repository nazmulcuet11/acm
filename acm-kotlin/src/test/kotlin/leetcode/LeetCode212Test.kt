package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode212Test {
    val sut = LeetCode212()

    @Test
    fun testCase1() {
        val board: Array<CharArray> = arrayOf(
            charArrayOf('o','a','a','n'),
            charArrayOf('e','t','a','e'),
            charArrayOf('i','h','k','r'),
            charArrayOf('i','f','l','v'),
        )
        val words: Array<String> = arrayOf("oath", "pea", "eat", "rain")
        val expected = listOf("oath", "eat")

        assertEquals(
            expected,
            sut.findWords(board, words)
        )
    }

    @Test
    fun testCase2() {
        val board: Array<CharArray> = arrayOf(
            charArrayOf('a','a'),
            charArrayOf('a','a'),
        )
        val words: Array<String> = arrayOf("aaaaa")
        val expected = listOf<String>()

        assertEquals(
            expected,
            sut.findWords(board, words)
        )
    }
}