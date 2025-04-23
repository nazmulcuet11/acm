package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1399Test {
    private val sut = LeetCode1399()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.countLargestGroup(13)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.countLargestGroup(2)
        )
    }
}