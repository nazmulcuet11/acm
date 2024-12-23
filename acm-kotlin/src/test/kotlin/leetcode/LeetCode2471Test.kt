package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode2471Test {
    private val sut = LeetCode2471()

    @Test
    fun case1() {
        val tree = buildTree(listOf(1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10))
        assertEquals(
            3,
            sut.minimumOperations(tree)
        )
    }

    @Test
    fun case2() {
        val tree = buildTree(listOf(1, 3, 2, 7, 6, 5, 4))
        assertEquals(
            3,
            sut.minimumOperations(tree)
        )
    }

    @Test
    fun case3() {
        val tree = buildTree(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(
            0,
            sut.minimumOperations(tree)
        )
    }


    private fun buildTree(
        i: Int,
        values: List<Int?>
    ): LeetCode2471.TreeNode? {
        if (i >= values.size) {
            return null
        }

        val value = values[i] ?: return null
        val node = LeetCode2471.TreeNode(value)
        node.left = buildTree(i * 2 + 1, values)
        node.right = buildTree(i * 2 + 2, values)
        return node
    }

    private fun buildTree(values: List<Int?>) = buildTree(0, values)
}