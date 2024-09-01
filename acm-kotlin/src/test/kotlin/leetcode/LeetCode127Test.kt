package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeetCode127Test {
    private val sut = LeetCode127()

    @Test
    fun testCaseOne() {
        assertEquals(
            5,
            sut.ladderLength(
                "hit",
                "cog",
                listOf("hot","dot","dog","lot","log","cog")
            )
        )
    }

    @Test
    fun testCaseTwo() {
        assertEquals(
            0,
            sut.ladderLength(
                "hit",
                "cog",
                listOf("hot","dot","dog","lot","log")
            )
        )
    }
}