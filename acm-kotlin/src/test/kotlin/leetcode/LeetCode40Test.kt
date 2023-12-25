package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.sorted

class LeetCode40Test {
    private val sut = LeetCode40()
    
    @Test
    fun testCaseOne() {
        assertEquals(
            sorted(
                listOf(
                    listOf(1, 1, 6),
                    listOf(1, 2, 5),
                    listOf(1, 7),
                    listOf(2, 6),
                )
            ),
            sorted(sorted(sut.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8)))
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            sorted(
                listOf(
                    listOf(1, 2, 2),
                    listOf(5),
                )
            ),
            sorted(sut.combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
        )
    }
}

