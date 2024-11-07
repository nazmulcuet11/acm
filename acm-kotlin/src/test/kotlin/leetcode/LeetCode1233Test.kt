package leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode1233Test {
    private val sut = LeetCode1233()

    @Test
    fun testCaseOne() {
        assertContentEquals(
            listOf("/a", "/c/d", "/c/f"),
            sut.removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f"))
        )
    }

    @Test
    fun testCaseTwo() {
        assertContentEquals(
            listOf("/a"),
            sut.removeSubfolders(arrayOf("/a", "/a/b/c", "/a/b/d"))
        )
    }

    @Test
    fun testCaseThree() {
        assertContentEquals(
            listOf("/a/b/c", "/a/b/ca", "/a/b/d"),
            sut.removeSubfolders(arrayOf("/a/b/c", "/a/b/ca", "/a/b/d"))
        )
    }
}