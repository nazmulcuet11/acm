package leetcode;

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3333Test {
    private val sut = LeetCode3333()

    @Test
    fun case1() {
        assertEquals(
            5,
            sut.possibleStringCount(
                "aabbccdd",
                7
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            1,
            sut.possibleStringCount(
                "aabbccdd",
                8
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            8,
            sut.possibleStringCount(
                "aaabbb",
                3
            )
        )
    }


    @Test
    fun case4() {
        assertEquals(
            3,
            sut.possibleStringCount(
                "ccnjuccc",
                7
            )
        )
    }
}


//cnjuccc
//ccnjucc
//ccnjuccc

