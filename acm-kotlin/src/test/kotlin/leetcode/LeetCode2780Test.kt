package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2780Test {
    private val sut = LeetCode2780()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.minimumIndex(listOf(1, 2, 2, 2))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.minimumIndex(listOf(2, 1, 3, 1, 1, 1, 7, 1, 2, 1))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            -1,
            sut.minimumIndex(listOf(3, 3, 3, 3, 7, 2, 2))
        )
    }

    @Test
    fun case4() {
        assertEquals(
            -1,
            sut.minimumIndex(listOf(3, 3, 3, 7, 2, 2, 3))
        )
    }
}