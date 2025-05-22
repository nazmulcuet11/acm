package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3362Test {
    private val sut = LeetCode3362()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.maxRemoval(
                intArrayOf(2, 0, 2),
                arrayOf(intArrayOf(0, 2), intArrayOf(0, 2), intArrayOf(1, 1))
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.maxRemoval(
                intArrayOf(1, 1, 1, 1),
                arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 2))
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            -1,
            sut.maxRemoval(
                intArrayOf(1, 2, 3, 4),
                arrayOf(intArrayOf(0, 3))
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            4,
            sut.maxRemoval(
                intArrayOf(1, 2),
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                    intArrayOf(0, 1),
                    intArrayOf(0, 0)
                )
            )
        )
    }

    @Test
    fun case5() {
        assertEquals(
            2,
            sut.maxRemoval(
                intArrayOf(0, 0, 1, 1, 0, 0),
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(0, 2),
                    intArrayOf(3, 5)
                )
            )
        )
    }
}