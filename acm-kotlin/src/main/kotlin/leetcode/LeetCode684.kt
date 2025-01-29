package leetcode

class LeetCode684 {
    /*
    // brute force
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size

        fun dfs(u: Int, graph: Array<MutableSet<Int>>, visited: MutableSet<Int>) {
            visited.add(u)
            for (v in graph[u]) {
                if (!visited.contains(v)) {
                    dfs(v, graph, visited)
                }
            }
        }

        val graph = Array(n + 1) { mutableSetOf<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }

        for (e in edges.reversed()) {
            val clonedGraph = graph.map { it.toMutableSet() }.toTypedArray()
            clonedGraph[e[0]].remove(e[1])
            clonedGraph[e[1]].remove(e[0])
            val visited = mutableSetOf<Int>()
            dfs(1, clonedGraph, visited)
            if (visited.count() == n) {
                return e
            }
        }
        return intArrayOf()
    }
    */

    // optimal
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val graph = Array(n + 1) { mutableSetOf<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        var cycleStart = -1
        val parent =  IntArray(n + 1) { -1 }
        val visited = BooleanArray(n + 1) { false }

        fun dfs(u: Int) {
            visited[u] = true
            for (v in graph[u]) {
                if (!visited[v]) {
                    parent[v] = u
                    dfs(v)
                } else if (parent[u] != v && cycleStart == -1) {
                    cycleStart = v
                    parent[v] = u
                }
            }
        }

        dfs(1)

        val cycleNodes = mutableSetOf<Int>()
        var current = parent[cycleStart]
        cycleNodes.add(cycleStart)
        while (current != cycleStart) {
            cycleNodes.add(current)
            current = parent[current]
        }

        for (e in edges.reversed()) {
            if (cycleNodes.contains(e[0]) && cycleNodes.contains(e[1])) {
                return e
            }
        }
        return intArrayOf()
    }
}