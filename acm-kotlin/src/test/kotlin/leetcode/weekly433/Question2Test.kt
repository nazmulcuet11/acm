package leetcode.weekly433

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Question2Test {
    private val sut = Question2()

    @Test
    fun case1() {
        assertEquals(
            24,
            sut.minMaxSums(
                intArrayOf(1, 2, 3),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            37,
            sut.minMaxSums(
                intArrayOf(4, 1, 3),
                3
            )
        )
    }
}