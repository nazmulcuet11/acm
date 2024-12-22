package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode2940Test {
    private val sut = LeetCode2940()

    @Test
    fun case1() {
        assertContentEquals(
            intArrayOf(2, 5, -1, 5, 2),
            sut.leftmostBuildingQueries(
                intArrayOf(6, 4, 8, 5, 2, 7),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 3),
                    intArrayOf(2, 4),
                    intArrayOf(3, 4),
                    intArrayOf(2, 2),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            intArrayOf(7, 6, -1, 4, 6),
            sut.leftmostBuildingQueries(
                intArrayOf(5, 3, 8, 2, 6, 1, 4, 6),
                arrayOf(
                    intArrayOf(0, 7),
                    intArrayOf(3, 5),
                    intArrayOf(5, 2),
                    intArrayOf(3, 0),
                    intArrayOf(1, 6),
                )
            )
        )
    }

    @Test
    fun case3() {
        assertContentEquals(
            intArrayOf(
                0,
                1,
                3,
                3,
                5,
                5,
                1,
                1,
                -1,
                -1,
                -1,
                -1,
                3,
                -1,
                2,
                3,
                5,
                5,
                3,
                -1,
                3,
                3,
                -1,
                -1,
                5,
                -1,
                5,
                -1,
                4,
                5,
                5,
                -1,
                5,
                -1,
                5,
                5
            ),
            sut.leftmostBuildingQueries(
                intArrayOf(1, 2, 1, 2, 1, 2),
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(0, 4),
                    intArrayOf(0, 5),
                    intArrayOf(1, 0),
                    intArrayOf(1, 1),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 0),
                    intArrayOf(2, 1),
                    intArrayOf(2, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4),
                    intArrayOf(2, 5),
                    intArrayOf(3, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2),
                    intArrayOf(3, 3),
                    intArrayOf(3, 4),
                    intArrayOf(3, 5),
                    intArrayOf(4, 0),
                    intArrayOf(4, 1),
                    intArrayOf(4, 2),
                    intArrayOf(4, 3),
                    intArrayOf(4, 4),
                    intArrayOf(4, 5),
                    intArrayOf(5, 0),
                    intArrayOf(5, 1),
                    intArrayOf(5, 2),
                    intArrayOf(5, 3),
                    intArrayOf(5, 4),
                    intArrayOf(5, 5),
                )
            )
        )
    }


    @Test
    fun case4() {
        assertContentEquals(
            intArrayOf(
                5,
                2,
                7,
                1,
                8,
                2,
                2,
                8,
                7,
                3
            ),
            sut.leftmostBuildingQueries(
                intArrayOf(
                    797786302,
                    180082097,
                    980626251,
                    111865822,
                    71291434,
                    583616758,
                    257364922,
                    953079117,
                    983564915
                ),
                arrayOf(
                    intArrayOf(3, 4),
                    intArrayOf(2, 1),
                    intArrayOf(0, 4),
                    intArrayOf(1, 1),
                    intArrayOf(2, 6),
                    intArrayOf(2, 0),
                    intArrayOf(1, 0),
                    intArrayOf(6, 2),
                    intArrayOf(7, 4),
                    intArrayOf(3, 3),
                )
            )
        )
    }
}