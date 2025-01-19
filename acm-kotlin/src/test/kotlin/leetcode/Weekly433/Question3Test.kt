package leetcode.Weekly433

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Question3Test {
    private val sut = Question3()

    @Test
    fun case1() {
        assertEquals(
            9,
            sut.minCost(
                4,
                arrayOf(
                    intArrayOf(3, 5, 7),
                    intArrayOf(6, 2, 9),
                    intArrayOf(4, 8, 1),
                    intArrayOf(7, 3, 5),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            18,
            sut.minCost(
                6,
                arrayOf(
                    intArrayOf(2,4,6),
                    intArrayOf(5,3,8),
                    intArrayOf(7,1,9),
                    intArrayOf(4,6,2),
                    intArrayOf(3,5,7),
                    intArrayOf(8,2,4),
                )
            )
        )
    }
}