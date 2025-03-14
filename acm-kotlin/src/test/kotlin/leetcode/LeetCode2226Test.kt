package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2226Test {
    private val sut = LeetCode2226()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.maximumCandies(intArrayOf(5, 8, 6), 3)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.maximumCandies(intArrayOf(2, 5), 11)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            3,
            sut.maximumCandies(intArrayOf(4, 7, 5), 4)
        )
    }
}