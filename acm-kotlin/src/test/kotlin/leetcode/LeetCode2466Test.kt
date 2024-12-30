package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2466Test {
    private val sut = LeetCode2466()

    @Test
    fun case1() {
        assertEquals(
            8,
            sut.countGoodStrings(3, 3, 1, 1)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.countGoodStrings(2, 3, 1, 2)
        )
    }
}