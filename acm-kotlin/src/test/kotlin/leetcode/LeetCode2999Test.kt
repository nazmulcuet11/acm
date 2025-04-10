package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2999Test {
    private val sut = LeetCode2999()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.numberOfPowerfulInt(1, 6000, 4, "124")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            2,
            sut.numberOfPowerfulInt(15, 215, 6, "10")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.numberOfPowerfulInt(1000, 2000, 4, "3000")
        )
    }

    @Test
    fun case4() {
        assertEquals(
            9,
            sut.numberOfPowerfulInt(1, 971, 9, "72")
        )
    }

    @Test
    fun case5() {
        assertEquals(
            0,
            sut.numberOfPowerfulInt(15000, 15001, 9, "9")
        )
    }
}