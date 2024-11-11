package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2601Test {
    private val sut = LeetCode2601()

    @Test
    fun testCase1() {
        assertEquals(
            true,
            sut.primeSubOperation(intArrayOf(4, 9, 6, 10))
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            true,
            sut.primeSubOperation(intArrayOf(6, 8, 11, 12))
        )
    }

    @Test
    fun testCase3() {
        assertEquals(
            false,
            sut.primeSubOperation(intArrayOf(5, 8, 3))
        )
    }

    @Test
    fun testCase4() {
        assertEquals(
            true,
            sut.primeSubOperation(intArrayOf(998, 2))
        )
    }

    @Test
    fun testCase5() {
        assertEquals(
            false,
            sut.primeSubOperation(intArrayOf(1, 20, 7, 12, 4))
        )
    }
}