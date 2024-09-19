package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode241Test {
    private val sut = LeetCode241()

    @Test
    fun testCaseOne() {
        assertContentEquals(
            listOf(0, 2).sorted(),
            sut.diffWaysToCompute("2-1-1").sorted()
        )
    }

    @Test
    fun testCaseTwo() {
        assertContentEquals(
            listOf(-34, -14, -10, -10, 10).sorted(),
            sut.diffWaysToCompute("2*3-4*5").sorted()
        )
    }
}