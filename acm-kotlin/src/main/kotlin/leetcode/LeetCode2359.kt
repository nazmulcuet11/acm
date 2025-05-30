package leetcode

import kotlin.math.max

class LeetCode2359 {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val n = edges.size

        fun getDistances(u: Int): IntArray {
            val distance = IntArray(n) { -1 }

            fun dfs(u: Int, d: Int) {
                if (u == -1 || distance[u] != -1) {
                    return
                }

                distance[u] = d
                dfs(edges[u], d + 1)
            }

            dfs(u, 0)
            return distance
        }

        val dist1 = getDistances(node1)
        val dist2 = getDistances(node2)
        var minDist = Int.MAX_VALUE
        var minIndex = -1
        for (i in dist1.indices) {
            if (dist1[i] == -1 || dist2[i] == -1) {
                continue
            }

            val maxDist = max(dist1[i], dist2[i])
            if (maxDist < minDist) {
                minIndex = i
                minDist = maxDist
            }
        }
        return minIndex
    }
}