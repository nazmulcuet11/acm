package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3097Test {
    private val sut = LeetCode3097()

    @Test
    fun testCase1() {
        assertEquals(
            1,
            sut.minimumSubarrayLength(intArrayOf(1, 2, 3), 2)
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            3,
            sut.minimumSubarrayLength(intArrayOf(2, 1, 8), 10)
        )
    }

    @Test
    fun testCase3() {
        assertEquals(
            1,
            sut.minimumSubarrayLength(intArrayOf(1, 2), 0)
        )
    }

    @Test
    fun testCase4() {
        assertEquals(
            3,
            sut.minimumSubarrayLength(intArrayOf(1, 2, 32, 21), 55)
        )
    }
}

/*
55 = 110111
32 = 100000
21 = 010101
2  = 000010
1  = 000001
 */