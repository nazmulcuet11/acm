package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode838Test {
    private val sut = LeetCode838()

    @Test
    fun case1() {
        assertEquals(
            "RR.L",
            sut.pushDominoes("RR.L")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "LL.RR.LLRRLL..",
            sut.pushDominoes(".L.R...LR..L..")
        )
    }
}