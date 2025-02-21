package leetcode

class LeetCode1261 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class FindElements(root: TreeNode?) {
        private val values = mutableSetOf<Int>()

        init {
            populate(root, 0)
        }

        private fun populate(node: TreeNode?, value: Int) {
            if (node == null) {
                return
            }

            values.add(value)
            populate(node.left, value * 2 + 1)
            populate(node.right, value * 2 + 2)
        }

        fun find(target: Int): Boolean {
            return values.contains(target)
        }
    }
}