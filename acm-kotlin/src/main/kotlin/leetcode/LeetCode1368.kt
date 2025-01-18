package leetcode

import java.util.*

class LeetCode1368 {
    private data class Node(val x: Int, val y: Int, val c: Int)
    private data class Move(val x: Int, val y: Int)

    private val moves = mapOf(
        1 to Move(0, 1),
        2 to Move(0, -1),
        3 to Move(1, 0),
        4 to Move(-1, 0)
    )

    private val comparator = Comparator<Node> { a, b -> a.c - b.c }

    fun minCost(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size
        val q = PriorityQueue<Node>(comparator)
        val cost = Array(m) { IntArray(n) { 99999 } }
        q.add(Node(0, 0, 0))
        cost[0][0] = 0
        while (q.isNotEmpty()) {
            val t = q.poll()
            for ((k, d) in moves) {
                val nx = t.x + d.x
                val ny = t.y + d.y
                val nc = t.c + (if (k == grid[t.x][t.y]) 0 else 1)
                if (nx in 0..<m && ny in 0..<n && cost[nx][ny] > nc) {
                    cost[nx][ny] = nc
                    q.add(Node(nx, ny, nc))
                }
            }
        }
        return cost[m - 1][n - 1]
    }
}