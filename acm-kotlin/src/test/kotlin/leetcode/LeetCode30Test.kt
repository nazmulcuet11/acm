package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode30Test {
    val sut = LeetCode30()

    @Test
    fun testCaseOne() {
        val expected = listOf(0,9)
        val actual = sut.findSubstring ("barfoothefoobarman", arrayOf("foo","bar"))
        assertEquals(expected, actual)
    }

    @Test
    fun testCaseTwo() {
        val expected = listOf<Int>()
        val actual = sut.findSubstring ("wordgoodgoodgoodbestword", arrayOf("word","good","best","word"))
        assertEquals(expected, actual)
    }

    @Test
    fun testCaseThree() {
        val expected = listOf<Int>(6,9,12)
        val actual = sut.findSubstring ("barfoofoobarthefoobarman", arrayOf("bar","foo","the"))
        assertEquals(expected, actual)
    }

    @Test
    fun testCaseFour() {
        val expected = listOf<Int>(8)
        val actual = sut.findSubstring ("wordgoodgoodgoodbestword", arrayOf("word","good","best","good"))
        assertEquals(expected, actual)
    }
}