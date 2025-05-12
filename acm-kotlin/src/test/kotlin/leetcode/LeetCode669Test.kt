package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

typealias TreeNode = LeetCode669.TreeNode

class LeetCode669Test {
    private val sut = LeetCode669()

    @Test
    fun case1() {
        val root = buildTree(listOf(1, 0, 2))
        val found = sut.trimBST(root, 1, 2)
        val expected = buildTree(listOf(1, null, 2))
        matchTree(expected, found)
    }

    @Test
    fun case2() {
        val root = buildTree(listOf(3, 0, 4, null, 2, null, null, 1))
        val found = sut.trimBST(root, 1, 3)
        val expected = buildTree(listOf(3, 2, null, 1))
        matchTree(expected, found)
    }

    private fun matchTree(a: TreeNode?, b: TreeNode?) {
        if (a == null && b == null) {
            return
        }

        assertEquals(a?.`val`, b?.`val`)

        matchTree(a?.left, b?.left)
        matchTree(a?.right, b?.right)
    }

    private fun buildTree(values: List<Int?>): TreeNode? {
        if (values.isEmpty() || values[0] == null) return null

        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var i = 1
        while (i < values.size) {
            val current = queue.removeFirst()

            if (i < values.size && values[i] != null) {
                current.left = TreeNode(values[i]!!)
                queue.add(current.left!!)
            }
            i++

            if (i < values.size && values[i] != null) {
                current.right = TreeNode(values[i]!!)
                queue.add(current.right!!)
            }
            i++
        }

        return root
    }
}