package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3085Test {
    private val sut = LeetCode3085()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.minimumDeletions("aabcaba", 0)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.minimumDeletions("dabdcbdcdcd", 2)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.minimumDeletions("aaabaaa", 2)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            1,
            sut.minimumDeletions("vvnowvov", 2)
        )
    }

    @Test
    fun case5() {
        assertEquals(
            6,
            sut.minimumDeletions("uzzezzuzenzu", 0)
        )
    }
}