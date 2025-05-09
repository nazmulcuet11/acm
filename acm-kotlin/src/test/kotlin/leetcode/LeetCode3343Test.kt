package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3343Test {
    private val sut = LeetCode3343()

    @Test
    fun case1() {
        assertEquals(
            2,
            sut.countBalancedPermutations("123")
        )
    }
    @Test
    fun case2() {
        assertEquals(
            1,
            sut.countBalancedPermutations("112")
        )
    }

    @Test
    fun case3() {
        assertEquals(
            0,
            sut.countBalancedPermutations("12345")
        )
    }

    @Test
    fun case4() {
        assertEquals(
            2,
            sut.countBalancedPermutations("132")
        )
    }

    @Test
    fun case5() {
        assertEquals(
            1,
            sut.countBalancedPermutations("211")
        )
    }

    @Test
    fun case6() {
        assertEquals(
            8,
            sut.countBalancedPermutations("4567")
        )
    }

    @Test
    fun case7() {
        assertEquals(
            1,
            sut.countBalancedPermutations("11")
        )
    }
}
