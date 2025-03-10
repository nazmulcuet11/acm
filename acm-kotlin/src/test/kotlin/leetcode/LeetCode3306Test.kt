package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3306Test {
    private val sut = LeetCode3306()

    @Test
    fun case1() {
        assertEquals(
            0,
            sut.countOfSubstrings("aeioqq", 1)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.countOfSubstrings("aeiou", 0)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            3,
            sut.countOfSubstrings("ieaouqqieaouqq", 1)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            3,
            sut.countOfSubstrings("iqeaouqi", 2)
        )
    }

    @Test
    fun case5() {
        assertEquals(
            2,
            sut.countOfSubstrings("aadieuoh", 1)
        )
    }
}