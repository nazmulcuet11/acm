package leetcode

import java.util.*

class LeetCode1028 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun recoverFromPreorder(traversal: String): TreeNode? {
        var i = 0
        val stack = Stack<TreeNode>()
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

            while (stack.isNotEmpty() && stack.size > depth) {
                stack.pop()
            }

            if (stack.isNotEmpty()) {
                if (stack.last().left == null) {
                    stack.last().left = node
                } else {
                    stack.last().right = node
                }
            }

            stack.add(node)
        }
        return root
    }
}