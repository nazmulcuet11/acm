package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeetCode2109Test {
    private val sut = LeetCode2109()

    @Test
    fun case1() {
        assertEquals(
            "Leetcode Helps Me Learn",
            sut.addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8, 13, 15))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "i code in py thon",
            sut.addSpaces("icodeinpython", intArrayOf(1, 5, 7, 9))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            " s p a c i n g",
            sut.addSpaces("spacing", intArrayOf(0, 1, 2, 3, 4, 5, 6))
        )
    }
}
