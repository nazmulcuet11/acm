package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1760Test {
    private val sut = LeetCode1760()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.minimumSize(
                intArrayOf(9),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.minimumSize(
                intArrayOf(2, 4, 8, 2),
                4
            )
        )
    }
}
