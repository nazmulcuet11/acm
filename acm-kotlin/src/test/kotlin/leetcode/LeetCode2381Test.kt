package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2381Test {
    private val sut = LeetCode2381()

    @Test
    fun case1() {
        assertEquals(
            "ace",
            sut.shiftingLetters(
                "abc",
                arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 2, 1), intArrayOf(0, 2, 1))
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "catz",
            sut.shiftingLetters(
                "dztz",
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 1))
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            "ywxcxcqii",
            sut.shiftingLetters(
                "xuwdbdqik",
                arrayOf(
                    intArrayOf(4, 8, 0),
                    intArrayOf(4, 4, 0),
                    intArrayOf(2, 4, 0),
                    intArrayOf(2, 4, 0),
                    intArrayOf(6, 7, 1),
                    intArrayOf(2, 2, 1),
                    intArrayOf(0, 2, 1),
                    intArrayOf(8, 8, 0),
                    intArrayOf(1, 3, 1)
                )
            )
        )
    }
}