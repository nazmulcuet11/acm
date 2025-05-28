package leetcode

import kotlin.math.max

class LeetCode3372 {
    fun maxTargetNodes(
        edges1: Array<IntArray>,
        edges2: Array<IntArray>,
        k: Int
    ): IntArray {
        fun buildGraph(edges: Array<IntArray>): Array<MutableSet<Int>> {
            val graph = Array(edges.size + 1) { mutableSetOf<Int>() }
            for (e in edges) {
                graph[e[0]].add(e[1])
                graph[e[1]].add(e[0])
            }
            return graph
        }

        fun countNodes(u: Int, graph: Array<MutableSet<Int>>, k: Int): Int {
            val visited = BooleanArray(graph.size) { false }
            var count = 0

            fun dfs(u: Int, d: Int) {
                if (visited[u] || d < 0) {
                    return
                }

                count++
                visited[u] = true
                for (v in graph[u]) {
                    dfs(v, d - 1)
                }
            }

            dfs(u, k)

            return count
        }

        val graph1 = buildGraph(edges1)
        val graph2 = buildGraph(edges2)

        var maxInGraph2 = 0
        for (u in graph2.indices) {
            maxInGraph2 = max(
                maxInGraph2,
                countNodes(u, graph2, k - 1)
            )
        }

        val ans = IntArray(graph1.size)
        for (u in graph1.indices) {
            ans[u] = countNodes(u, graph1, k) + maxInGraph2
        }
        return ans
    }
}