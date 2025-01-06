package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1769Test {
    private val sut = LeetCode1769()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(1, 1, 3),
            sut.minOperations("110")
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(11, 8, 5, 4, 3, 4),
            sut.minOperations("001011")
        )
    }
}