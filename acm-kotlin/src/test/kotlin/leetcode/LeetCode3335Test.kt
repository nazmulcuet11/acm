package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3335Test {
    private val sut = LeetCode3335()

    @Test
    fun case1() {
        assertEquals(
            7,
            sut.lengthAfterTransformations("abcyy", 2)
        )
    }

    @Test
    fun case2() {
        assertEquals(
            5,
            sut.lengthAfterTransformations("azbk", 1)
        )
    }
}