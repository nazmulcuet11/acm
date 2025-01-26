package leetcode

import java.util.*
import kotlin.math.max

class LeetCode2127 {
    private fun fillStack(
        u: Int,
        graph: List<List<Int>>,
        visited: BooleanArray,
        stack: Stack<Int>,
    ) {
        visited[u] = true
        for (v in graph[u]) {
            if (!visited[v]) {
                fillStack(v, graph, visited, stack)
            }
        }
        stack.add(u)
    }

    private fun transpose(graph: List<List<Int>>): List<MutableList<Int>> {
        val inverseGraph = List(graph.size) { mutableListOf<Int>() }
        for (u in graph.indices) {
            for (v in graph[u]) {
                inverseGraph[v].add(u)
            }
        }
        return inverseGraph
    }

    private fun findSCC(
        u: Int,
        graph: List<List<Int>>,
        visited: BooleanArray,
        components: MutableList<Int>
    ) {
        visited[u] = true
        components.add(u)
        for (v in graph[u]) {
            if (!visited[v]) {
                findSCC(v, graph, visited, components)
            }
        }
    }

    private fun maxTailLength(
        u: Int,
        graph: List<List<Int>>,
        visited: BooleanArray
    ): Int {
        if (visited[u]) {
            return 0
        }

        visited[u] = true
        var maxLength = 0
        for (v in graph[u]) {
            if (!visited[v]) {
                maxLength = max(maxLength, maxTailLength(v, graph, visited))
            }
        }
        return maxLength + 1
    }

    private fun ansForTwoLengthCycle(favorite: IntArray): Int {
        val n = favorite.size
        var graph = favorite.map { mutableListOf(it) }

        for (u in favorite.indices) {
            val v = favorite[u]
            if (favorite[v] == u) {
                graph[u].removeAll { true }
                graph[v].removeAll { true }
            }
        }

        var ans = 0
        graph = transpose(graph)
        val visited = BooleanArray(n) { false }
        for (u in favorite.indices) {
            val v = favorite[u]
            if (favorite[v] == u) {
                val a = maxTailLength(u, graph, visited)
                val b = maxTailLength(v, graph, visited)
                ans += a + b
            }
        }
        return ans
    }

    private fun ansForOtherCycle(favorite: IntArray): Int {
        val n = favorite.size
        val stack = Stack<Int>()
        var graph = favorite.map { mutableListOf(it) }
        var visited = BooleanArray(n) { false }
        // use SCC to find ans
        for (u in favorite.indices) {
            if(!visited[u]) {
                fillStack(u, graph, visited, stack)
            }
        }

        graph = transpose(graph)
        visited = BooleanArray(n) { false }
        var ans = 0
        while (stack.isNotEmpty()) {
            val u = stack.pop()
            if (!visited[u]) {
                val components = mutableListOf<Int>()
                findSCC(u, graph, visited, components)
                if (components.size > 2) {
                    ans = max(ans, components.size)
                }
            }
        }
        return ans
    }

    fun maximumInvitations(favorite: IntArray): Int {
        val a = ansForTwoLengthCycle(favorite)
        val b = ansForOtherCycle(favorite)
        return max(a, b)
    }
}