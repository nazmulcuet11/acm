package leetcode

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LeetCode3003Test {

    private val sut = LeetCode3003()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.maxPartitionsAfterOperations("accca", 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.maxPartitionsAfterOperations("aabaab", 3)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            4,
            sut.maxPartitionsAfterOperations("xxyz", 1)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            3,
            sut.maxPartitionsAfterOperations("aabcacc", 2)
        )
    }

    @Test
    fun case5() {
        assertEquals(
            3,
            sut.maxPartitionsAfterOperations("abbaaca", 2)
        )
    }
}