package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LeetCode2097Test {
    private val sut = LeetCode2097()

    @Test
    fun case1() {

        assertTrue(
            arrayOf(intArrayOf(11, 9), intArrayOf(9, 4), intArrayOf(4, 5), intArrayOf(5, 1))
                .contentDeepEquals(
                    sut.validArrangement(
                        arrayOf(intArrayOf(5, 1), intArrayOf(4, 5), intArrayOf(11, 9), intArrayOf(9, 4))
                    )
                )
        )
    }

    @Test
    fun case2() {
        assertTrue(
            arrayOf(intArrayOf(1, 3), intArrayOf(3, 2), intArrayOf(2, 1))
                .contentDeepEquals(
                    sut.validArrangement(
                        arrayOf(intArrayOf(1, 3), intArrayOf(3, 2), intArrayOf(2, 1))
                    )
                )

        )
    }

    @Test
    fun case3() {
        assertTrue(
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(1, 3))
                .contentDeepEquals(
                    sut.validArrangement(
                        arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 1))
                    )
                )
        )
    }


    @Test
    fun case4() {
        assertTrue(
            arrayOf(intArrayOf(8,0),intArrayOf(0,7),intArrayOf(7,8),intArrayOf(8,7),intArrayOf(7,0),intArrayOf(0,5),intArrayOf(5,0),intArrayOf(0,8),intArrayOf(8,5))
                .contentDeepEquals(
                    sut.validArrangement(
                        arrayOf(intArrayOf(8,5),intArrayOf(8,7),intArrayOf(0,8),intArrayOf(0,5),intArrayOf(7,0),intArrayOf(5,0),intArrayOf(0,7),intArrayOf(8,0),intArrayOf(7,8))
                    )
                )
        )
    }
}