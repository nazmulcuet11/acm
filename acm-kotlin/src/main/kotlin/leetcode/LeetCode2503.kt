package leetcode

import java.util.*

class LeetCode2503 {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        data class QueueEntry(val v: Int, val i: Int, val j: Int)

        fun isValid(i: Int, j: Int) = i >= 0 && i < grid.size && j >= 0 && j < grid[i].size

        fun isVisited(i: Int, j: Int) = grid[i][j] == -1

        val comparator = Comparator<QueueEntry> { a, b -> a.v - b.v }

        var count = 0
        val pq = PriorityQueue(comparator)
        fun dijkstra(n: Int) {
            while (pq.isNotEmpty() && pq.peek().v < n) {
                val (_, i, j) = pq.poll()
                if (isVisited(i, j)) {
                    continue
                }

                grid[i][j] = -1
                count++
                val dx = arrayOf(0, 0, 1, -1)
                val dy = arrayOf(1, -1, 0, 0)
                for ((x, y) in dx.zip(dy)) {
                    if (isValid(i + x, j + y)) {
                        pq.add(QueueEntry(grid[i + x][j + y], i + x, j + y))
                    }
                }
            }
        }

        val sortedQueries = queries.withIndex().sortedBy { it.value }
        val ans = IntArray(sortedQueries.size)
        pq.add(QueueEntry(grid[0][0], 0, 0))
        for ((i, q) in sortedQueries) {
            dijkstra(q)
            ans[i] = count
        }
        return ans
    }
}