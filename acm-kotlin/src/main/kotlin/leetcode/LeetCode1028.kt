package leetcode

import java.util.*

class LeetCode1028 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun recoverFromPreorder(traversal: String): TreeNode? {
        var i = 0
        val nodes = mutableMapOf<Int, Stack<TreeNode>>()
        var root: TreeNode? = null
        while (i < traversal.length) {
            var depth = 0
            while (i < traversal.length && traversal[i] == '-') {
                depth++
                i++
            }

            var value = 0
            while (i < traversal.length && traversal[i].isDigit()) {
                value = value * 10 + (traversal[i].code - '0'.code)
                i++
            }

            val node = TreeNode(value)
            if (root == null) {
                root = node
            }

            if (nodes[depth] == null) {
                nodes[depth] = Stack()
            }
            nodes[depth]?.add(node)

            if (depth > 0) {
                nodes[depth - 1]?.let {
                    while (it.isNotEmpty() && it.last().left != null && it.last().right != null) {
                        it.last()
                    }

                    if (it.last().left == null) {
                        it.last().left = node
                    } else {
                        it.last().right = node
                    }
                }
            }
        }
        return root
    }
}