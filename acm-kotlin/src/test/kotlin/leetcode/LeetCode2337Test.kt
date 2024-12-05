package leetcode

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class LeetCode2337Test {
    private val sut = LeetCode2337()

    @Test
    fun case1() {
        assertTrue(sut.canChange("_L__R__R_", "L______RR"))
    }

    @Test
    fun case2() {
        assertFalse(sut.canChange("R_L_", "__LR"))
    }

    @Test
    fun case3() {
        assertFalse(sut.canChange("_R", "R_"))
    }

    @Test
    fun case4() {
        assertTrue(sut.canChange("__", "__"))
    }
}
