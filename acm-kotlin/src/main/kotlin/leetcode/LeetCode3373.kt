package leetcode

import kotlin.math.max

class LeetCode3373 {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
        fun buildGraph(edges: Array<IntArray>): Array<MutableSet<Int>> {
            val graph = Array(edges.size + 1) { mutableSetOf<Int>() }
            for (e in edges) {
                graph[e[0]].add(e[1])
                graph[e[1]].add(e[0])
            }
            return graph
        }

        val graph1 = buildGraph(edges1)
        val graph2 = buildGraph(edges2)

        fun createGroup(graph: Array<MutableSet<Int>>): IntArray {
            val group = IntArray(graph.size) { -1 }
            fun dfs(u: Int, g: Int) {
                if (group[u] != -1) {
                    return
                }

                group[u] = g
                for (v in graph[u]) {
                    dfs(v, g xor 1)
                }
            }

            dfs(0, 0)
            return group
        }

        val nodeToGroup1 = createGroup(graph1)
        val nodeToGroup2 = createGroup(graph2)

        val groupCount1 = IntArray(2)
        for (g in nodeToGroup1) {
            groupCount1[g]++
        }

        val groupCount2 = IntArray(2)
        for (g in nodeToGroup2) {
            groupCount2[g]++
        }

        val group2Max = max(groupCount2[0], groupCount2[1])

        val ans = IntArray(graph1.size)
        for (u in ans.indices) {
            val g1 = nodeToGroup1[u]
            ans[u] = groupCount1[g1] + group2Max
        }
        return ans
    }
}