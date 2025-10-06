package leetcode

import java.util.PriorityQueue
import kotlin.math.max

class LeetCode778 {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val times = List(n) { MutableList(n) { -1 } }

        data class Cell(val x: Int, val y: Int) {
            val neighbors
                get() = listOf(
                    Cell(x - 1, y),
                    Cell(x, y - 1),
                    Cell(x + 1, y),
                    Cell(x, y + 1),
                )

            val isValid
                get() = x in 0..<n && y in 0..<n

            var time
                get() = times[x][y]
                set(value) { times[x][y] = value }

            val isVisited
                get() = times[x][y] != -1
        }

        val queue = PriorityQueue<Cell>(compareBy { it.time })
        times[0][0] = grid[0][0]
        queue.add(Cell(0, 0))

        while (queue.isNotEmpty()) {
            val cell = queue.poll()

            for (neighbor in cell.neighbors) {
                if (!neighbor.isValid) continue
                if (neighbor.isVisited) continue
                neighbor.time = max(cell.time, grid[neighbor.x][neighbor.y])
                queue.add(neighbor)
            }
        }

        return times[n - 1][n - 1]
    }
}