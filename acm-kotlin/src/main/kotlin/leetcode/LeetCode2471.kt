package leetcode

class LeetCode2471 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun <E>MutableList<E>.swap(i: Int, j: Int) {
        val t = this[i]
        this[i] = this[j]
        this[j] = t
    }

    private fun minSwapToSort(a: List<Int>): Int {
        val indexedValues = a.withIndex().sortedBy { it.value }.toMutableList()
        var ans = 0
        var i = 0
        while (i < indexedValues.size) {
            if (indexedValues[i].index == i) {
                i++
            } else {
                indexedValues.swap(indexedValues[i].index, i)
                ans++
            }
        }

        return ans
    }

    fun minimumOperations(root: TreeNode?): Int {
        var ans = 0
        var nodes = mutableListOf<TreeNode>()
        if (root != null) {
            nodes.add(root)
        }
        while (nodes.isNotEmpty()) {
            ans += minSwapToSort(nodes.map { it.`val` })
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