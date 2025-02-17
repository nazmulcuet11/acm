package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1079Test {
    private val sut = LeetCode1079()

    @Test
    fun case1() {
        assertEquals(
            8,
            sut.numTilePossibilities("AAB")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            188,
            sut.numTilePossibilities("AAABBC")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            1,
            sut.numTilePossibilities("V")
        )
    }

    @Test
    fun case4() {
        assertEquals(
            1956,
            sut.numTilePossibilities("ABCDEF")
        )
    }
}