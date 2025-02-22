package leetcode

import java.util.*

class LeetCode1028 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun recoverFromPreorder(traversal: String): TreeNode? {
        var i = 0
        val stack = Stack<Pair<Int, TreeNode>>()
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

            while (stack.isNotEmpty() && stack.last().first != depth - 1) {
                stack.pop()
            }

            if (stack.isNotEmpty()) {
                if (stack.last().second.left == null) {
                    stack.last().second.left = node
                } else {
                    stack.last().second.right = node
                }
            }

            stack.add(Pair(depth, node))
        }
        return root
    }
}