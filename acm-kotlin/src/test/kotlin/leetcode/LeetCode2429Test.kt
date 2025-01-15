package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2429Test {
    private val sut = LeetCode2429()

    @Test
    fun case1() {
        assertEquals(
            3,
            sut.minimizeXor(3, 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.minimizeXor(1, 12)
        )
    }
}