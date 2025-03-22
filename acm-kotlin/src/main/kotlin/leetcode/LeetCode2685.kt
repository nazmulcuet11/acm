package leetcode

class LeetCode2685 {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableSetOf<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }

        val visited = BooleanArray(n) { false }

        fun dfs(u: Int): List<Int> {
            visited[u] = true
            val nodes = mutableListOf(u)
            for (v in graph[u]) {
                if (!visited[v]) {
                    nodes += dfs(v)
                }
            }
            return nodes
        }

        fun isCompletelyConnected(nodes: List<Int>): Boolean {
            for (u in nodes) {
                if (graph[u].size != nodes.size - 1) {
                    return false
                }
            }
            return true
        }

        var ans = 0
        for (u in 0..<n) {
            if (!visited[u]) {
                val nodes = dfs(u)
                if (isCompletelyConnected(nodes)) {
                    ans++
                }
            }
        }
        return ans
    }
}