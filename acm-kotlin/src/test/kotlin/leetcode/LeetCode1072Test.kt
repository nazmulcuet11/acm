package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1072Test {
    private val sut = LeetCode1072()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.maxEqualRowsAfterFlips(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 1),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.maxEqualRowsAfterFlips(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            2,
            sut.maxEqualRowsAfterFlips(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 1, 0),
                )
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            2,
            sut.maxEqualRowsAfterFlips(
                arrayOf(
                    intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
                    intArrayOf(1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1),
                    intArrayOf(1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
                    intArrayOf(1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1),
                )
            )
        )
    }
}