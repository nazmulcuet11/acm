package leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LeetCode2028Test {
    private val sut = LeetCode2028()

    @Test
    fun testCaseOne() {
        assertArrayEquals(
            intArrayOf(6,6),
            sut.missingRolls(
                intArrayOf(3,2,4,3),
                4,
                2,
            )
        )
    }


    @Test
    fun testCaseTwo() {
        assertArrayEquals(
            intArrayOf(3,2,2,2),
            sut.missingRolls(
                intArrayOf(1,5,6),
                3,
                4,
            )
        )
    }

    @Test
    fun testCaseThree() {
        assertArrayEquals(
            intArrayOf(),
            sut.missingRolls(
                intArrayOf(1,2,3,4),
                6,
                4,
            )
        )
    }

    @Test
    fun testCaseFour() {
        assertArrayEquals(
            intArrayOf(),
            sut.missingRolls(
                intArrayOf(6,3,4,3,5,3),
                1,
                6,
            )
        )
    }

    @Test
    fun testCaseFive() {
        assertArrayEquals(
            intArrayOf(5,5,5,5,5,5,5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4),
            sut.missingRolls(
                intArrayOf(4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5),
                4,
                40,
            )
        )
    }

    @Test
    fun testCaseSix() {
        assertArrayEquals(
            intArrayOf(),
            sut.missingRolls(
                intArrayOf(4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3),
                2,
                53,
            )
        )
    }
}