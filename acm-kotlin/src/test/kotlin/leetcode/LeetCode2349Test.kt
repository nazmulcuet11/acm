package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2349Test {
    @Test
    fun case1() {
        val sut = LeetCode2349.NumberContainers()

        assertEquals(-1, sut.find(10))
        sut.change(2, 10)
        sut.change(1, 10)
        sut.change(3, 10)
        sut.change(5, 10)
        assertEquals(1, sut.find(10))
        sut.change(1, 20)
        assertEquals(2, sut.find(10))
    }
}