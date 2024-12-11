package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2779Test {
    private val sut = LeetCode2779()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.maximumBeauty(
                intArrayOf(4, 6, 1, 2),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.maximumBeauty(
                intArrayOf(1, 1, 1, 1),
                10
            )
        )
    }
}