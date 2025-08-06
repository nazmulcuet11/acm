package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeetCode3479Test {
    private val sut = LeetCode3479()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.numOfUnplacedFruits(
                intArrayOf(4, 2, 5),
                intArrayOf(3, 5, 4),
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.numOfUnplacedFruits(
                intArrayOf(3, 6, 1),
                intArrayOf(6, 4, 7),
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.numOfUnplacedFruits(
                intArrayOf(31),
                intArrayOf(6),
            )
        )
    }
}