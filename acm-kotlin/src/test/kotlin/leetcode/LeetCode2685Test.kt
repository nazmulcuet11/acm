package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2685Test {
    private val sut = LeetCode2685()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.countCompleteComponents(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.countCompleteComponents(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(3, 5)
                )
            )
        )
    }
}