package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2106Test {
    private val sut = LeetCode2106()

    @Test
    fun case5() {
        val fruits: Array<IntArray> = arrayOf(
            intArrayOf(0, 7),
            intArrayOf(7, 4),
            intArrayOf(9, 10),
            intArrayOf(12, 6),
            intArrayOf(14, 8),
            intArrayOf(16, 5),
            intArrayOf(17, 8),
            intArrayOf(19, 4),
            intArrayOf(20, 1),
            intArrayOf(21, 3),
            intArrayOf(24, 3),
            intArrayOf(25, 3),
            intArrayOf(26, 1),
            intArrayOf(28, 10),
            intArrayOf(30, 9),
            intArrayOf(31, 6),
            intArrayOf(32, 1),
            intArrayOf(37, 5),
            intArrayOf(40, 9)
        )

        assertEquals(
            71,
            sut.maxTotalFruits(fruits, 21, 30)
        )
    }
}