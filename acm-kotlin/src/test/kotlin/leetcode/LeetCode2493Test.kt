package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2493Test {
    private val sut = LeetCode2493()

    @Test
    fun case1() {
        assertEquals(
            19,
            sut.magnificentSets(
                24,
                arrayOf(
                    intArrayOf(2, 13),
                    intArrayOf(7, 3),
                    intArrayOf(5, 3),
                    intArrayOf(21, 1),
                    intArrayOf(5, 1),
                    intArrayOf(4, 13),
                    intArrayOf(21, 19),
                    intArrayOf(7, 13),
                    intArrayOf(15, 3),
                    intArrayOf(21, 22),
                    intArrayOf(17, 19),
                    intArrayOf(23, 22),
                    intArrayOf(14, 13),
                )
            )
        )
    }
}
