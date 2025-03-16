package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2594Test {
    private val sut = LeetCode2594()

    @Test
    fun case1() {
        assertEquals(
            16,
            sut.repairCars(intArrayOf(4, 2, 3, 1), 10)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            16,
            sut.repairCars(intArrayOf(5, 1, 8), 6)
        )
    }
}