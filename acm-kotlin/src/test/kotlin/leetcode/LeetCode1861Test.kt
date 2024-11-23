package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LeetCode1861Test {
    private val sut = LeetCode1861()

    @Test
    fun case1() {
        assertTrue {
            arrayOf(
                charArrayOf('.'),
                charArrayOf('#'),
                charArrayOf('#'),
            ).contentDeepEquals(
                sut.rotateTheBox(
                    arrayOf(
                        charArrayOf('#', '.', '#'),
                    )
                )
            )
        }
    }

    @Test
    fun case2() {
        assertTrue {
            arrayOf(
                charArrayOf('#', '.'),
                charArrayOf('#', '#'),
                charArrayOf('*', '*'),
                charArrayOf('.', '.'),
            ).contentDeepEquals(
                sut.rotateTheBox(
                    arrayOf(
                        charArrayOf('#', '.', '*', '.'),
                        charArrayOf('#', '#', '*', '.'),
                    )
                )
            )
        }
    }

    @Test
    fun case3() {
        assertTrue {
            arrayOf(
                charArrayOf('.', '#', '#'),
                charArrayOf('.', '#', '#'),
                charArrayOf('#', '#', '*'),
                charArrayOf('#', '*', '.'),
                charArrayOf('#', '.', '*'),
                charArrayOf('#', '.', '.'),
            ).contentDeepEquals(
                sut.rotateTheBox(
                    arrayOf(
                        charArrayOf('#', '#', '*', '.', '*', '.'),
                        charArrayOf('#', '#', '#', '*', '.', '.'),
                        charArrayOf('#', '#', '#', '.', '#', '.'),
                    )
                )
            )
        }
    }
}