package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2375Test {
    private val sut = LeetCode2375()

    @Test
    fun case1() {
        assertEquals(
            "123549876",
            sut.smallestNumber("IIIDIDDD")
        )
    }

    @Test
    fun case2() {
        assertEquals(
            "4321",
            sut.smallestNumber("DDD")
        )
    }
}