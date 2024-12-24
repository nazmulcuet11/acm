package leetcode


class LeetCode3203 {

    private data class NodeDistance(val u: Int, val v: Int, val distance: Int)

    private fun generateGraph(edges: Array<IntArray>): Array<MutableSet<Int>> {
        val graph = Array<MutableSet<Int>>(edges.size + 1) { mutableSetOf() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        return graph
    }

    private fun findFarthestNode(graph: Array<MutableSet<Int>>, source: Int): NodeDistance {
        val distance = Array<Int>(graph.size) { -1 }
        val q = ArrayDeque<Int>()
        var destination = source
        distance[source] = 0
        q.add(source)
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            for (v in graph[u]) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1
                    if (distance[v] > distance[destination]) {
                        destination = v
                    }
                    q.add(v)
                }
            }
        }
        return NodeDistance(source, destination, distance[destination])
    }

    private fun findDiameter(graph: Array<MutableSet<Int>>): Int {
        return findFarthestNode(graph, findFarthestNode(graph, 0).v).distance
    }

    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        val tree1 = generateGraph(edges1)
        val tree2 = generateGraph(edges2)
        val diameter1 = findDiameter(tree1)
        val diameter2 = findDiameter(tree2)
        val combined = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1
        return maxOf(diameter1, diameter2, combined)
    }
}