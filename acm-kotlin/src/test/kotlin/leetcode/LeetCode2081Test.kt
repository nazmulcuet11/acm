package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2081Test {
    private val sut = LeetCode2081()

    @Test
    fun case1() {
        assertEquals(
            25,
            sut.kMirror(2, 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            499,
            sut.kMirror(3, 7)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            20379000,
            sut.kMirror(7, 17)
        )
    }
}