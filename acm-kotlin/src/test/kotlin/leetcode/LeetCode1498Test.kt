package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1498Test {
    private val sut = LeetCode1498()

    @Test
    fun case1() {
        assertEquals(
            4,
            sut.numSubseq(
                intArrayOf(3, 5, 6, 7),
                9
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            6,
            sut.numSubseq(
                intArrayOf(3, 3, 6, 8),
                10
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            61,
            sut.numSubseq(
                intArrayOf(2, 3, 3, 4, 6, 7),
                12
            )
        )
    }
}