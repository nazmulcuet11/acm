package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1422Test {
    private val sut = LeetCode1422()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.maxScore("011101")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.maxScore("00111")
        )
    }


    @Test
    fun case3() {
        assertEquals(
            3,
            sut.maxScore("1111")
        )
    }

    @Test
    fun case4() {
        assertEquals(
            1,
            sut.maxScore("00")
        )
    }
}