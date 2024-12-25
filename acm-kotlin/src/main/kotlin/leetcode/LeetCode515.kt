package leetcode

class LeetCode515 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun largestValues(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        var nodes = mutableListOf<TreeNode>()
        if (root != null) {
            nodes.add(root)
        }
        while (nodes.isNotEmpty()) {
            ans.add(nodes.map { it.`val` }.max())
            val nextNodes = mutableListOf<TreeNode>()
            for (node in nodes) {
                node.left?.let { nextNodes.add(it) }
                node.right?.let { nextNodes.add(it) }
            }
            nodes = nextNodes
        }
        return ans
    }
}