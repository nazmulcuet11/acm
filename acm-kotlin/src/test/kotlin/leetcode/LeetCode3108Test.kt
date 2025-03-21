package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode3108Test {
    private val sut = LeetCode3108()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(1, -1),
            sut.minimumCost(
                5,
                arrayOf(
                    intArrayOf(0, 1, 7),
                    intArrayOf(1, 3, 7),
                    intArrayOf(1, 2, 1)
                ),
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(3, 4)
                )
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(0),
            sut.minimumCost(
                3,
                arrayOf(
                    intArrayOf(0, 2, 7),
                    intArrayOf(0, 1, 15),
                    intArrayOf(1, 2, 6),
                    intArrayOf(1, 2, 1)
                ),
                arrayOf(
                    intArrayOf(1, 2)
                )
            )
        )
    }
}