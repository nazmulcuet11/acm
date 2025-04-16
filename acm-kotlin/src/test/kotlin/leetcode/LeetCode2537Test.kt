package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2537Test {
    private val sut = LeetCode2537()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.countGood(
                intArrayOf(1, 1, 1, 1, 1),
                10
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.countGood(
                intArrayOf(3, 1, 4, 3, 2, 2, 4),
                2
            )
        )
    }
}