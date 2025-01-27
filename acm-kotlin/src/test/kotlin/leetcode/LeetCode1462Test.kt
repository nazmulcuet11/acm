package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1462Test {
    private val sut = LeetCode1462()

    @Test
    fun case1() {
        assertContentEquals(
            listOf(false, true),
            sut.checkIfPrerequisite(
                2,
                arrayOf(intArrayOf(1, 0)),
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            listOf(false, false),
            sut.checkIfPrerequisite(
                2,
                arrayOf(),
                arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
            )
        )
    }

    @Test
    fun case3() {
        assertContentEquals(
            listOf(true, true),
            sut.checkIfPrerequisite(
                3,
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 0), intArrayOf(2, 0)),
                arrayOf(intArrayOf(1, 0), intArrayOf(1, 2))
            )
        )
    }

    @Test
    fun case4() {
        assertContentEquals(
            listOf(true, false, true, false),
            sut.checkIfPrerequisite(
                5,

                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)),
                arrayOf(intArrayOf(0, 4), intArrayOf(4, 0), intArrayOf(1, 3), intArrayOf(3, 0))
            )
        )
    }
}