package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3399Test {
    private val sut = LeetCode3399()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.minLength("000001", 1)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.minLength("0000", 2)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.minLength("0101", 0)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            1,
            sut.minLength("00000", 2)
        )
    }

    @Test
    fun case5() {
        assertEquals(
            2,
            sut.minLength("0110", 1)
        )
    }
}