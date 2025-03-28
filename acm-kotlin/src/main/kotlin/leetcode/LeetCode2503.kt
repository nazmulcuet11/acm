package leetcode

import java.util.*

class LeetCode2503 {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val sortedQueries = queries.withIndex().sortedBy { it.value }

        data class GridIndex(val i: Int, val j: Int)
        data class QueueEntry(val v: Int, val g: GridIndex)

        fun isValid(g: GridIndex): Boolean {
            return g.i >= 0 && g.i < grid.size && g.j >= 0 && g.j < grid.first().size
        }

        fun getValidNeighbors(g: GridIndex): List<GridIndex> {
            val offset = listOf(
                GridIndex(0, 1),
                GridIndex(1, 0),
                GridIndex(-1, 0),
                GridIndex(0, -1)
            )

            val validNeighbors = mutableListOf<GridIndex>()
            for (o in offset) {
                val neighbor = GridIndex(g.i + o.i, g.j + o.j)
                if (isValid(neighbor)) {
                    validNeighbors.add(neighbor)
                }
            }
            return validNeighbors
        }

        fun isVisited(g: GridIndex): Boolean {
            return grid[g.i][g.j] == -1
        }

        val comparator = Comparator<QueueEntry> { a, b -> a.v - b.v }

        var count = 0
        val pq = PriorityQueue(comparator)
        fun dijkstra(x: Int) {
            while (pq.isNotEmpty() && pq.peek().v < x) {
                val (_, g) = pq.poll()
                if (isVisited(g)) {
                    continue
                }
                grid[g.i][g.j] = -1
                count++
                val neighbors = getValidNeighbors(g)
                for (n in neighbors) {
                    if (!isVisited(n)) {
                        pq.add(QueueEntry(grid[n.i][n.j], n))
                    }
                }
            }
        }

        val ans = IntArray(sortedQueries.size)
        pq.add(QueueEntry(grid[0][0], GridIndex(0, 0)))
        for ((i, q) in sortedQueries) {
            dijkstra(q)
            ans[i] = count
        }
        return ans
    }
}