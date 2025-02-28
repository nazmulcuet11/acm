package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1092Test {
    private val sut = LeetCode1092()

    @Test
    fun case1() {
        assertEquals(
            "cabac",
            sut.shortestCommonSupersequence("abac", "cab")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "aaaaaaaa",
            sut.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa")
        )
    }
}