package leetcode.weekly429

import leetcode.LeetCode1900
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1900Test {
    private val sut = LeetCode1900()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(3, 4),
            sut.earliestAndLatest(11, 2, 4)
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(1, 1),
            sut.earliestAndLatest(5, 1, 5)
        )
    }

    @Test
    fun case3() {
        assertContentEquals(
            intArrayOf(1, 1),
            sut.earliestAndLatest(4, 2, 3)
        )
    }

    @Test
    fun case4() {
        assertContentEquals(
            intArrayOf(2, 5),
            sut.earliestAndLatest(27, 14, 22)
        )
    }
}