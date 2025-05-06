package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode790Test {
    private val sut = LeetCode790()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.numTilings(3)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.numTilings(1)
        )
    }


    @Test
    fun case3() {
        assertEquals(
            2,
            sut.numTilings(2)
        )
    }

    @Test
    fun case4() {
        assertEquals(
            11,
            sut.numTilings(4)
        )
    }
}