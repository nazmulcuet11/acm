package leetcode

class LeetCode802 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val inverseGraph = Array(n) { mutableListOf<Int>() }
        val outDegree = IntArray(n) { 0 }
        for (u in graph.indices) {
            for (v in graph[u]) {
                inverseGraph[v].add(u)
            }
            outDegree[u] = graph[u].size
        }

        val q = ArrayDeque<Int>()
        for (i in outDegree.indices) {
            if (outDegree[i] == 0) {
                q.add(i)
            }
        }

        val ans = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val v = q.removeFirst()
            ans.add(v)
            for (u in inverseGraph[v]) {
                outDegree[u]--
                if (outDegree[u] == 0) {
                    q.add(u)
                }
            }
        }

        return ans.sorted()
    }
}