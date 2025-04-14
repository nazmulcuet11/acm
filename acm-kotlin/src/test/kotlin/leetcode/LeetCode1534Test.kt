package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1534Test {
    private val sut = LeetCode1534()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.countGoodTriplets(
                intArrayOf(3, 0, 1, 1, 9, 7),
                7,
                2,
                3
            )
        )
    }
}