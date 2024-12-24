package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3203Test {
    private val sut = LeetCode3203()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.minimumDiameterAfterMerge(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                ),
                arrayOf(
                    intArrayOf(0, 1),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.minimumDiameterAfterMerge(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(2, 4),
                    intArrayOf(2, 5),
                    intArrayOf(3, 6),
                    intArrayOf(2, 7),
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(2, 4),
                    intArrayOf(2, 5),
                    intArrayOf(3, 6),
                    intArrayOf(2, 7),
                )
            )
        )
    }
}