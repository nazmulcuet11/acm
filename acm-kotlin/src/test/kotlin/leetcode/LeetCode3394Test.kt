package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeetCode3394Test {
    private val sut = LeetCode3394()

    @Test
    fun case1() {
        assertTrue {
            sut.checkValidCuts(
                5,
                arrayOf(
                    intArrayOf(1, 0, 5, 2),
                    intArrayOf(0, 2, 2, 4),
                    intArrayOf(3, 2, 5, 3),
                    intArrayOf(0, 4, 4, 5)
                )
            )
        }
    }

    @Test
    fun case2() {
        assertTrue {
            sut.checkValidCuts(
                4,
                arrayOf(
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(2, 0, 3, 4),
                    intArrayOf(0, 2, 2, 3),
                    intArrayOf(3, 0, 4, 3)
                )
            )
        }
    }

    @Test
    fun case3() {
        assertFalse {
            sut.checkValidCuts(
                4,
                arrayOf(
                    intArrayOf(0, 2, 2, 4),
                    intArrayOf(1, 0, 3, 2),
                    intArrayOf(2, 2, 3, 4),
                    intArrayOf(3, 0, 4, 2),
                    intArrayOf(3, 2, 4, 4)
                )
            )
        }
    }

    @Test
    fun case4() {
        assertFalse {
            sut.checkValidCuts(
                3,
                arrayOf(
                    intArrayOf(0, 0, 1, 3),
                    intArrayOf(1, 0, 2, 2),
                    intArrayOf(2, 0, 3, 2),
                    intArrayOf(1, 2, 3, 3),
                )
            )
        }
    }
}