package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1475Test {
    private val sut = LeetCode1475()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(4, 2, 4, 2, 3),
            sut.finalPrices(intArrayOf(8, 4, 6, 2, 3))
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5),
            sut.finalPrices(intArrayOf(1, 2, 3, 4, 5))
        )
    }
}