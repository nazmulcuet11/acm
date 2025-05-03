package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1007Test {
    private val sut = LeetCode1007()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.minDominoRotations(
                intArrayOf(2, 1, 2, 4, 2, 2),
                intArrayOf(5, 2, 6, 2, 3, 2)
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.minDominoRotations(
                intArrayOf(3, 5, 1, 2, 3),
                intArrayOf(3, 6, 3, 3, 4)
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.minDominoRotations(
                intArrayOf(1, 2, 1, 1, 1, 2, 2, 2),
                intArrayOf(2, 1, 2, 2, 2, 2, 2, 2)
            )
        )
    }
}