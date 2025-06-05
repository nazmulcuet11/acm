package leetcode

import kotlin.math.min

/*
class LeetCode1061 {
    fun smallestEquivalentString(
        s1: String,
        s2: String,
        baseStr: String
    ): String {
        fun Char.index() = code - 'a'.code

        val graph = Array(26) { mutableListOf<Int>() }
        for (i in s1.indices) {
            val u = s1[i].index()
            val v = s2[i].index()
            graph[u].add(v)
            graph[v].add(u)
        }

        fun findSmallestRepresentative(x: Int): Int {
            val visited = BooleanArray(26) { false }
            var ans = x
            fun dfs(u: Int) {
                if (visited[u]) {
                    return
                }

                ans = min(ans, u)
                visited[u] = true
                for (v in graph[u]) {
                    dfs(v)
                }
            }

            dfs(x)
            return ans
        }

        val map = IntArray(26)
        for (u in 0..25) {
            map[u] = findSmallestRepresentative(u)
        }

        fun Char.smallestRepresentative() =  Char('a'.code + map[index()])

        val sb = StringBuilder()
        for (c in baseStr) {
            sb.append(c.smallestRepresentative())
        }
        return sb.toString()
    }
}
*/

class LeetCode1061 {
    fun smallestEquivalentString(
        s1: String,
        s2: String,
        baseStr: String
    ): String {
        fun Char.index() = code - 'a'.code

        val representative = IntArray(26) { it }

        fun findRepresentative(u: Int): Int {
            if (representative[u] == u) {
                return u
            }

            representative[u] = findRepresentative(representative[u])
            return representative[u]
        }

        fun union(u: Int, v: Int) {
            val x = findRepresentative(u)
            val y = findRepresentative(v)
            val r = min(x, y)
            representative[x] = r
            representative[y] = r
        }

        for (i in s1.indices) {
            val u = s1[i].index()
            val v = s2[i].index()
            union(u, v)
        }

        fun Char.smallestRepresentative() =  Char('a'.code + findRepresentative(index()))

        val sb = StringBuilder()
        for (c in baseStr) {
            sb.append(c.smallestRepresentative())
        }
        return sb.toString()
    }
}