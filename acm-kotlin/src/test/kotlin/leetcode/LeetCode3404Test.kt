package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3404Test {
    private val sut = LeetCode3404()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.numberOfSubsequences(intArrayOf(1, 2, 3, 4, 3, 6, 1))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.numberOfSubsequences(intArrayOf(3, 4, 3, 4, 3, 4, 3, 4))
        )
    }
}