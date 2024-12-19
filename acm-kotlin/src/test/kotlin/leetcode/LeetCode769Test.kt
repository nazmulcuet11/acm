package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode769Test {
    private val sut = LeetCode769()

    @Test
    fun case1() {
        assertEquals(
            1,
            sut.maxChunksToSorted(intArrayOf(5, 4, 3, 2, 1, 0))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4,
            sut.maxChunksToSorted(intArrayOf(1, 0, 2, 3, 4))
        )
    }
}