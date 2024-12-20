package leetcode

class LeetCode2415 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        var nodes = mutableListOf<TreeNode>()
        if (root != null) {
            nodes.add(root)
        }
        var level = 0
        while (nodes.size > 0) {
            level++
            val nextNodes = mutableListOf<TreeNode>()
            for (node in nodes) {
                node.left?.let { nextNodes.add(it) }
                node.right?.let { nextNodes.add(it) }
            }

            if (level % 2 == 1) {
                val reversedValues = nextNodes.map { it.`val` }.reversed()
                for (i in nextNodes.indices) {
                    nextNodes[i].`val` = reversedValues[i]
                }
            }

            nodes = nextNodes
        }
        return root
    }
}