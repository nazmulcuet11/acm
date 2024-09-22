package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode386Test {
    private val sut = LeetCode386()

    @Test
    fun testCaseOne() {
        assertContentEquals(
            listOf(1,10,11,12,13,2,3,4,5,6,7,8,9),
            sut.lexicalOrder(13)
        )
    }

    @Test
    fun testCaseTwo() {
        assertContentEquals(
            listOf(1, 2),
            sut.lexicalOrder(2)
        )
    }
}