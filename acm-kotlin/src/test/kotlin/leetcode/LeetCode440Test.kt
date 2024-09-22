package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode440Test {
    private val sut = LeetCode440()

    @Test
    fun testCaseOne() {
        assertEquals(
            10,
            sut.findKthNumber(13, 2)
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            1,
            sut.findKthNumber(1, 1)
        )
    }

    @Test
    fun testCaseThree() {
//        assertEquals(
//            999_999_999,
//            sut.findKthNumber(1000_000_000, 1000_000_000)
//        )

        assertEquals(
            9,
            sut.findKthNumber(10, 10)
        )
    }
}