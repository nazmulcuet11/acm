package leetcode.weekly429

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Question2Test {
    private val sut = Question2()

    @Test
    fun case1() {
        assertEquals(
            6,
            sut.maxDistinctElements(
                intArrayOf(1,2,2,3,3,4),
                2
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            3,
            sut.maxDistinctElements(
                intArrayOf(4, 4, 4,4),
                1
            )
        )
    }
}