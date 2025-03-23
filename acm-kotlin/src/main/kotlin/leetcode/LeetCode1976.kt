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

        val dag = Array(n) { mutableListOf<Int>() }
        for (r in roads) {
            if (costs[r[0]] + r[2] == costs[r[1]]) {
                dag[r[1]].add(r[0])
            } else if (costs[r[1]] + r[2] == costs[r[0]]) {
                dag[r[0]].add(r[1])
            }
        }

        val mod = 1_000_000_000 + 7
        val ways = Array<Long>(n) { -1 }
        fun dfs(u: Int): Long {
            if (u == 0) {
                return 1
            }

            if (ways[u] != -1L) {
                return ways[u]
            }

            var ans = 0L
            for (v in dag[u]) {
                ans = (ans + dfs(v)) % mod
            }
            ways[u] = ans
            return ans
        }

        return dfs(n - 1).toInt()
    }
}