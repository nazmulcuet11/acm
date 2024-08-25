package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode295Test {
    val sut = LeetCode295()

    @Test
    fun testCaseOne() {
        sut.addNum(1)
        sut.addNum(2)
        assertEquals(1.5, sut.findMedian())
        sut.addNum(3)
        assertEquals(2.0, sut.findMedian())
    }
}