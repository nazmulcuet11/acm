package leetcode

class LeetCode3243 {
    private fun bfs(graph: Map<Int, List<Int>>, n: Int): Int {
        val q = ArrayDeque<Int>()
        val cost = Array<Int>(n) { -1 }
        q.add(0)
        cost[0] = 0
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            if (u == n - 1) {
                break
            }
            for (v in graph.getOrDefault(u, emptyList())) {
                if (cost[v] == -1) {
                    cost[v] = cost[u] + 1
                    q.add(v)
                }
            }
        }
        return cost[n-1]
    }

    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0..<n - 1) {
            graph[i] = mutableListOf(i + 1)
        }

        val ans = mutableListOf<Int>()
        for (q in queries) {
            graph[q[0]]?.add(q[1])
            ans.add(bfs(graph, n))
        }
        return ans.toIntArray()
    }
}