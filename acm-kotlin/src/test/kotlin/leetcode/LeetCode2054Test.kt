package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2054Test {
    private val sut = LeetCode2054()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.maxTwoEvents(
                arrayOf(
                    intArrayOf(1, 3, 2),
                    intArrayOf(4, 5, 2),
                    intArrayOf(2, 4, 3),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.maxTwoEvents(
                arrayOf(
                    intArrayOf(1, 3, 2),
                    intArrayOf(4, 5, 2),
                    intArrayOf(1, 5, 5),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            8,
            sut.maxTwoEvents(
                arrayOf(
                    intArrayOf(1, 5, 3),
                    intArrayOf(1, 5, 1),
                    intArrayOf(6, 6, 5),
                )
            )
        )
    }


    @Test
    fun case4() {
        assertEquals(
            165,
            sut.maxTwoEvents(
                arrayOf(
                    intArrayOf(66, 97, 90),
                    intArrayOf(98, 98, 68),
                    intArrayOf(38, 49, 63),
                    intArrayOf(91, 100, 42),
                    intArrayOf(92, 100, 22),
                    intArrayOf(1, 77, 50),
                    intArrayOf(64, 72, 97),
                )
            )
        )
    }
}
