package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2558Test {
    private val sut = LeetCode2558()

    @Test
    fun case1() {
        assertEquals(
            29,
            sut.pickGifts(
                intArrayOf(25, 64, 9, 4, 100),
                4
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.pickGifts(
                intArrayOf(1, 1, 1, 1),
                4
            )
        )
    }
}