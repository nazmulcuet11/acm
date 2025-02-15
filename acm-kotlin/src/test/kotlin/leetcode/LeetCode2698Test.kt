package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2698Test {
    private val sut = LeetCode2698()

    @Test
    fun case1() {
        assertEquals(
            182,
            sut.punishmentNumber(10)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1478,
            sut.punishmentNumber(37)
        )
    }
}