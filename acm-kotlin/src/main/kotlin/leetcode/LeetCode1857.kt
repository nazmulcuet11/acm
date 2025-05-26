package leetcode

import kotlin.math.max

class LeetCode1857 {
    fun largestPathValue(
        colors: String,
        edges: Array<IntArray>
    ): Int {
        val n = colors.length

        val indegree = IntArray(n) { 0 }
        val graph = Array(n) { mutableSetOf<Int>() }
        for (e in edges) {
            val u = e[0]
            val v = e[1]
            graph[u].add(v)
            indegree[v]++
        }

        fun hasCycle(): Boolean {
            val state = IntArray(n) { 0 }
            fun dfs(u: Int): Boolean {
                if (state[u] == 1) {
                    return true
                }

                if (state[u] == 2) {
                    return false
                }

                state[u] = 1
                for (v in graph[u]) {
                    if (dfs(v)) {
                        return true
                    }
                }
                state[u] = 2
                return false
            }

            for (v in 0..<n) {
                if (dfs(v)) {
                    return true
                }
            }
            return false
        }

        if (hasCycle()) {
            return -1
        }

        fun Char.index() = code - 'a'.code

        val queue = ArrayDeque<Int>()
        val maxColor = Array(n) { IntArray(26) { 0 } }

        for (v in 0..<n) {
            if (indegree[v] == 0) {
                queue.add(v)
                maxColor[v][colors[v].index()] = 1
            }
        }

        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            for (v in graph[u]) {
                for (c in 0..<26) {
                    if (c == colors[v].index()) {
                        maxColor[v][c] = max(maxColor[v][c], maxColor[u][c] + 1)
                    } else {
                        maxColor[v][c] = max(maxColor[v][c], maxColor[u][c])
                    }
                }

                indegree[v]--
                if (indegree[v] == 0) {
                    queue.add(v)
                }
            }
        }

        var ans = 0
        for (v in 0..<n) {
            for (c in 0..<26) {
                ans = max(ans, maxColor[v][c])
            }
        }
        return ans
    }
}