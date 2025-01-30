package leetcode

import kotlin.math.max

class LeetCode2493 {

    private fun isGraphBipartite(graph: Array<MutableSet<Int>>): Boolean {
        val color = IntArray(graph.size) { 0 }

        fun isComponentBipartite(s: Int): Boolean {
            val q = ArrayDeque<Int>()
            q.add(s)
            color[s] = 1
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                for (v in graph[u]) {
                    if (color[v] == 0) {
                        color[v] = -1 * color[u]
                        q.add(v)
                    } else if (color[v] == color[u]) {
                        return false
                    }
                }
            }
            return true
        }

        for (s in graph.indices) {
            if (color[s] == 0 && !isComponentBipartite(s)) {
                return false
            }
        }
        return true
    }

    private fun getConnectedComponents(graph: Array<MutableSet<Int>>): List<List<Int>> {
        val visited = BooleanArray(graph.size) { false }
        fun dfs(u: Int): List<Int> {
            visited[u] = true
            val ans = mutableListOf(u)
            for (v in graph[u]) {
                if (!visited[v]) {
                    ans += dfs(v)
                }
            }
            return ans
        }

        val components = mutableListOf<List<Int>>()
        for (u in 1..<graph.size) {
            if (!visited[u]) {
                components.add(dfs(u))
            }
        }
        return components
    }

    private fun getLevelCount(graph: Array<MutableSet<Int>>, s: Int): Int {
        val q = ArrayDeque<Int>()
        val visited = BooleanArray(graph.size) { false }
        q.add(s)
        visited[s] = true
        var level = 0
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val u = q.removeFirst()
                for (v in graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true
                        q.add(v)
                    }
                }
            }
            level++
        }
        return level
    }


    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableSetOf<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }

        if (!isGraphBipartite(graph)) {
            return -1
        }

        var ans = 0
        val components = getConnectedComponents(graph)
        for (component in components) {
            var maxLevel = 0
            for (u in component) {
                maxLevel = max(maxLevel, getLevelCount(graph, u))
            }
            ans += maxLevel
        }
        return ans
    }
}
