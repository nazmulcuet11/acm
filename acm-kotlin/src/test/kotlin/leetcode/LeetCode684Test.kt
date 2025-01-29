package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode684Test {
    private val sut = LeetCode684()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(1, 4),
            sut.findRedundantConnection(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(4, 5),
            sut.findRedundantConnection(
                arrayOf(
                    intArrayOf(2, 4),
                    intArrayOf(3, 4),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(4, 5),
                )
            )
        )
    }
}