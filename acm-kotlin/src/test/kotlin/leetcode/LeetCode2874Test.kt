package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2874Test {
    private val sut = LeetCode2874()

    @Test
    fun case1() {
        assertEquals(
            77,
            sut.maximumTripletValue(intArrayOf(12, 6, 1, 2, 7))
        )
    }

    @Test
    fun case2() {
        assertEquals(
            133,
            sut.maximumTripletValue(intArrayOf(1, 10, 3, 4, 19))
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.maximumTripletValue(intArrayOf(1, 2, 3))
        )
    }
}