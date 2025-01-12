package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LeetCode2116Test {
    private val sut = LeetCode2116()

    @Test
    fun case1() {
        assertTrue {
            sut.canBeValid("))()))", "010100")
        }
    }

    @Test
    fun case2() {
        assertTrue {
            sut.canBeValid("()()", "0000")
        }
    }

    @Test
    fun case3() {
        assertFalse {
            sut.canBeValid(")", "0")
        }
    }

    @Test
    fun case4() {
        assertTrue {
            sut.canBeValid(
                "((()(()()))()((()()))))()((()(()",
                "10111100100101001110100010001001"
            )
        }
    }

    @Test
    fun case5() {
        assertFalse {
            sut.canBeValid(
                "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(",
                "100011110110011011010111100111011101111110000101001101001111"
            )
        }
    }
}