package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2033Test {
    private val sut = LeetCode2033()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.minOperations(
                arrayOf(intArrayOf(2, 4), intArrayOf(6, 8)),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.minOperations(
                arrayOf(intArrayOf(1, 5), intArrayOf(2, 3)),
                1
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            -1,
            sut.minOperations(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                2
            )
        )
    }
}