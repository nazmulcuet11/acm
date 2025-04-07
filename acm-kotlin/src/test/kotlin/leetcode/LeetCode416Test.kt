package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeetCode416Test {
    private val sut = LeetCode416()

    @Test
    fun case1() {
        assertTrue {
            sut.canPartition(intArrayOf(1, 5, 11, 5))
        }
    }

    @Test
    fun case2() {
        assertFalse {
            sut.canPartition(intArrayOf(1, 2, 3, 5))
        }
    }
}