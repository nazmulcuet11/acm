package leetcode

import java.util.*

class LeetCode2577 {
    data class Cell(val x: Int, val y: Int)
    data class Entry(val cell: Cell, val cost: Int)
    data class Move(val x: Int, val y: Int)

    private val moves = arrayOf(
        Move(0, -1),
        Move(-1, 0),
        Move(0, 1),
        Move(1, 0),
    )

    fun minimumTime(grid: Array<IntArray>): Int {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1

        val m = grid.size
        val n = grid.first().size
        val source = Cell(0, 0)
        val target = Cell(m - 1, n - 1)
        fun isValid(x: Int, y: Int): Boolean = x in 0..<m && y in 0..<n

        val visited = mutableSetOf<Cell>()
        val pq = PriorityQueue<Entry>(compareBy { it.cost })
        pq.add(Entry(source, 0))
        visited.add(source)
        while (pq.isNotEmpty()) {
            val (u, c) = pq.remove()
            if (u == target) {
                return c
            }
            for (d in moves) {
                val v = Cell(u.x + d.x, u.y + d.y)
                if (!visited.contains(v) && isValid(v.x, v.y)) {
                    visited.add(v)
                    if (c + 1 >= grid[v.x][v.y]) {
                        pq.add(Entry(v, c + 1))
                    } else {
                        // jump between two cells until able to reach the next cell
                        if ((grid[v.x][v.y] - c) % 2 == 0) {
                            pq.add(Entry(v, grid[v.x][v.y] + 1))
                        } else {
                            pq.add(Entry(v, grid[v.x][v.y]))
                        }
                    }
                }
            }
        }
        // should never happen
        return -1
    }
}


