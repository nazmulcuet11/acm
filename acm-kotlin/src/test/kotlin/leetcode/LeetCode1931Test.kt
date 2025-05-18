package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1931Test {
    private val sut = LeetCode1931()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.colorTheGrid(1, 1)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            6,
            sut.colorTheGrid(1, 2)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            580986,
            sut.colorTheGrid(5, 5)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            54,
            sut.colorTheGrid(2, 3)
        )
    }

    @Test
    fun case5() {
        assertEquals(
            54,
            sut.colorTheGrid(3, 2)
        )
    }
}