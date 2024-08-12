package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode224Test {
    val sut = LeetCode224()

    @Test
    fun testCase1() {
        assertEquals(
            2,
            sut.calculate("1 + 1")
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            3,
            sut.calculate(" 2-1 + 2 ")
        )
    }

    @Test
    fun testCase3() {
        assertEquals(
            23,
            sut.calculate("(1+(4+5+2)-3)+(6+8)")
        )
    }
}