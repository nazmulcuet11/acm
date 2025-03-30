package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode763Test {
    private val sut = LeetCode763()

    @Test
    fun case1() {
        assertContentEquals(
            listOf(9, 7, 8),
            sut.partitionLabels("ababcbacadefegdehijhklij")
        )
    }

    @Test
    fun case2() {
        assertContentEquals(
            listOf(10),
            sut.partitionLabels("eccbbbbdec")
        )
    }
}