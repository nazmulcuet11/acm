package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2818Test {
    private val sut = LeetCode2818()

    @Test
    fun case1() {
        assertEquals(
            81,
            sut.maximumScore(listOf(8, 3, 9, 3, 8), 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            4788,
            sut.maximumScore(listOf(19, 12, 14, 6, 10, 18), 3)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            256720975,
            sut.maximumScore(listOf(3289, 2832, 14858, 22011), 6)
        )
    }
}