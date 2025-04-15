package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2179Test {
    private val sut = LeetCode2179()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.goodTriplets(
                intArrayOf(2, 0, 1, 3),
                intArrayOf(0, 1, 2, 3)
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.goodTriplets(
                intArrayOf(4, 0, 1, 3, 2),
                intArrayOf(4, 1, 0, 2, 3)
            )
        )
    }
}