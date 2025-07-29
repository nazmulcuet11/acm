package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode2411Test {
    private val sut = LeetCode2411()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(3, 3, 2, 2, 1),
            sut.smallestSubarrays(intArrayOf(1, 0, 2, 1, 3))
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(2, 1),
            sut.smallestSubarrays(intArrayOf(1, 2))
        )
    }
}