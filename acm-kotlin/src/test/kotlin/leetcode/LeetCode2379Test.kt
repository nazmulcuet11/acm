package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2379Test {
    private val sut = LeetCode2379()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.minimumRecolors("WBBWWBBWBW", 7)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            0,
            sut.minimumRecolors("WBWBBBW", 2)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            3,
            sut.minimumRecolors("BWWWBB", 6)
        )
    }
}