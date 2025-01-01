package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1679Test {
    private val sut = LeetCode1679()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.maxOperations(intArrayOf(1, 2, 3, 4), 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.maxOperations(intArrayOf(3, 1, 3, 4, 3), 6)
        )
    }
}