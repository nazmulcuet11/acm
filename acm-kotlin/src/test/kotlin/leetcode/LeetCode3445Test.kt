package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3445Test {
    private val sut = LeetCode3445()

    @Test
    fun case1() {
        assertEquals(
            -1,
            sut.maxDifference("12233", 4)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.maxDifference("1122211", 3)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            -1,
            sut.maxDifference("110", 3)
        )
    }
}