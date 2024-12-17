package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2182Test {
    private val sut = LeetCode2182()

    @Test
    fun case1() {
        assertEquals(
            "zzcccac",
            sut.repeatLimitedString("cczazcc", 3)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "bbabaa",
            sut.repeatLimitedString("aababab", 2)
        )
    }
}