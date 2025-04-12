package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3272Test {
    private val sut = LeetCode3272()

    @Test
    fun case1() {
        assertEquals(
            27,
            sut.countGoodIntegers(3, 5)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.countGoodIntegers(1, 4)
        )
    }

    @Test
    fun case3() {
        assertEquals(
            2468,
            sut.countGoodIntegers(5, 6)
        )
    }
}