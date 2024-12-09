package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode3152Test {
    private val sut = LeetCode3152()

    @Test
    fun case1() {
        assertContentEquals(
            booleanArrayOf(false),
            sut.isArraySpecial(
                intArrayOf(3, 4, 1, 2, 6),
                arrayOf(
                    intArrayOf(0, 4),
                )
            )
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            booleanArrayOf(false, true),
            sut.isArraySpecial(
                intArrayOf(4, 3, 1, 6),
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(2, 3),
                )
            )
        )
    }
}
