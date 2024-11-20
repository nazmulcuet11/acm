package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2516Test {
    private val sut = LeetCode2516()

    @Test
    fun case1() {
        assertEquals(
            8,
            sut.takeCharacters("aabaaaacaabc", 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            -1,
            sut.takeCharacters("a", 1)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.takeCharacters("a", 0)
        )
    }


    @Test
    fun case4() {
        assertEquals(
            4,
            sut.takeCharacters("ccbabcc", 1)
        )
    }
}