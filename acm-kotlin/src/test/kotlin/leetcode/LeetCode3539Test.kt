package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3539Test {
    private val sut = LeetCode3539()

    @Test
    fun case1() {
        assertEquals(
            991600007,
            sut.magicalSum(
                5,
                5,
                intArrayOf(1, 10, 100, 10000, 1000000)
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            170,
            sut.magicalSum(
                2,
                2,
                intArrayOf(5, 4, 3, 2, 1)
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            28,
            sut.magicalSum(
                1,
                1,
                intArrayOf(28)
            )
        )
    }

    @Test
    fun case4() {
        assertEquals(
            817948606,
            sut.magicalSum(
                6,
                5,
                intArrayOf(
                    48525,
                    9163,
                    70584,
                    31594,
                    64613,
                    97928,
                    66225,
                    71071,
                    81859,
                    59816,
                    89027,
                    14121,
                    40300,
                    68154,
                    32258,
                    33108,
                    53538,
                    39140,
                    18727,
                    42175,
                    72023,
                    26550,
                    72187
                )
            )
        )
    }

    @Test
    fun case5() {
        assertEquals(
            36096,
            sut.magicalSum(
                3,
                1,
                intArrayOf(36, 8, 26)
            )
        )
    }
}