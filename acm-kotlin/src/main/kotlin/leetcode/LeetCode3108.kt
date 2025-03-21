package leetcode

class LeetCode3108 {
    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val representative = IntArray(n) { 0 }
        for (i in 0..<n) {
            representative[i] = i
        }

        fun findRepresentative(u: Int): Int {
            if (representative[u] == u) {
                return u
            }
            representative[u] = findRepresentative(representative[u])
            return representative[u]
        }

        fun union(u: Int, v: Int) {
            val a = findRepresentative(u)
            val b = findRepresentative(v)
            if (a != b) {
                representative[a] = b
            }
        }

        for (e in edges) {
            union(e[0], e[1])
        }

        val costs = IntArray(n) { -1 }
        for (e in edges) {
            val r = findRepresentative(e[0])
            if (costs[r] == -1) {
                costs[r] = e[2]
            } else {
                costs[r] = costs[r] and e[2]
            }
        }

        val ans = IntArray(query.size) { -1 }
        for ((i, q) in query.withIndex()) {
            val a = findRepresentative(q[0])
            val b = findRepresentative(q[1])
            if (a == b) {
                ans[i] = costs[a]
            }
        }
        return ans
    }
}