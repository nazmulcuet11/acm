package leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class LeetCode2352Tests {
    private val sut = LeetCode2352()

    @Test
    fun testCase1() {
        assertEquals(
            1,
            sut.equalPairs(
                arrayOf(
                    intArrayOf(3,2,1),
                    intArrayOf(1,7,6),
                    intArrayOf(2,7,7),
                )
            )
        )
    }

    @Test
    fun testCase2() {
        assertEquals(
            3,
            sut.equalPairs(
                arrayOf(
                    intArrayOf(3,1,2,2),
                    intArrayOf(1,4,4,5),
                    intArrayOf(2,4,2,2),
                    intArrayOf(2,4,2,2),
                )
            )
        )
    }
}