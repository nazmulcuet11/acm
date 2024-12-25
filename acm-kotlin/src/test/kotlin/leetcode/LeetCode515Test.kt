package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class LeetCode515Test {
    private val sut = LeetCode515()

    @Test
    fun case1() {
        val tree = buildTree(listOf(1, 3, 2, 5, 3, null, 9))
        assertContentEquals(
            listOf(1, 3, 9),
            sut.largestValues(tree)
        )
    }

    @Test
    fun case2() {
        val tree = buildTree(listOf(1, 2, 3))
        assertContentEquals(
            listOf(1, 3),
            sut.largestValues(tree)
        )
    }

    private fun buildTree(
        i: Int,
        values: List<Int?>
    ): LeetCode515.TreeNode? {
        if (i >= values.size) {
            return null
        }

        val value = values[i] ?: return null
        val node = LeetCode515.TreeNode(value)
        node.left = buildTree(i * 2 + 1, values)
        node.right = buildTree(i * 2 + 2, values)
        return node
    }

    private fun buildTree(values: List<Int?>) = buildTree(0, values)
}