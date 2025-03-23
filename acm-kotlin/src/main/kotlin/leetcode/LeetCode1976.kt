package leetcode

import java.util.*

class LeetCode1976 {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (r in roads) {
            graph[r[0]].add(Pair(r[1], r[2]))
            graph[r[1]].add(Pair(r[0], r[2]))
        }

        val costs = LongArray(n) { -1 }
        val pq = PriorityQueue<Pair<Int, Long>> { a, b -> (a.second - b.second).toInt() }
        pq.add(Pair(0, 0))
        while (pq.isNotEmpty()) {
            val (u, c) = pq.poll()
            if (costs[u] == -1L) {
                costs[u] = c
                for ((v, x) in graph[u]) {
                    if (costs[v] == -1L) {
                        pq.add(Pair(v, c + x))
                    }
                }
            }
        }

        val mod = 1_000_000_000 + 7
        val ways = Array<Long>(n) { -1 }
        fun dfs(v: Int): Long {
            if (v == 0) {
                return 1
            }

            if (ways[v] != -1L) {
                return ways[v]
            }

            var ans = 0L
            for ((u, c) in graph[v]) {
                if (costs[u] + c == costs[v]) {
                    ans = (ans + dfs(u)) % mod
                }
            }
            ways[v] = ans
            return ans
        }

        return dfs(n - 1).toInt()
    }
}