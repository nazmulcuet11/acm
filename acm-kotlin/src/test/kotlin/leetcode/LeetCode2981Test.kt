package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2981Test {
    private val sut = LeetCode2981()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.maximumLength("aaaa")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.maximumLength("abcdef")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.maximumLength("abcaba")
        )
    }

    @Test
    fun case4() {
        assertEquals(
            2,
            sut.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde")
        )
    }
}