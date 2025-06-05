package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode1061Test {
    private val sut = LeetCode1061()

    @Test
    fun case1() {
        assertEquals(
            "hdld",
            sut.smallestEquivalentString(
                "hello",
                "world",
                "hold"
            )
        )
    }
}