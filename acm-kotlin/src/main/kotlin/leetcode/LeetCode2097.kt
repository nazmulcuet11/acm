package leetcode

class LeetCode2097 {
    private val graph = mutableMapOf<Int, MutableList<Int>>()
    private val inDegree = mutableMapOf<Int, Int>()
    private val outDegree = mutableMapOf<Int, Int>()
    private val nodes = mutableSetOf<Int>()

    private fun getInDegree(node: Int) = inDegree.getOrDefault(node, 0)
    private fun getOutDegree(node: Int) = outDegree.getOrDefault(node, 0)

    private fun populateData(pairs: Array<IntArray>) {
        for (p in pairs) {
            val u = p[0]
            val v = p[1]
            nodes.add(u)
            nodes.add(v)
            outDegree[u] = getOutDegree(u) + 1
            inDegree[v] = getInDegree(v) + 1
            graph[u]?.add(v) ?: run {
                graph[u] = mutableListOf(v)
            }
        }
    }

    private fun getStartingNode(): Int {
        for (node in nodes) {
            if (getOutDegree(node) - getInDegree(node) == 1) {
                return node
            }
        }
        return nodes.first()
    }

    private fun findEulerPath(u: Int, path: MutableList<Int>) {
        graph[u]?.let {
            while (it.isNotEmpty()) {
                val v = it.removeLast()
                findEulerPath(v, path)
            }
        }
        path.add(u)
    }

    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        populateData(pairs)
        val staringNode = getStartingNode()
        val path = mutableListOf<Int>()
        findEulerPath(staringNode, path)
        path.reverse()
        val ans = mutableListOf<IntArray>()
        for (i in 1..<path.size) {
            ans.add(intArrayOf(path[i - 1], path[i]))
        }
        return ans.toTypedArray()
    }
}