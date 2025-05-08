package leetcode

import java.util.*
import kotlin.math.max

class LeetCode3342 {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val m = moveTime.size
        val n = moveTime[0].size

        fun isLast(i: Int, j: Int) = i == m - 1 && j == n - 1

        fun isVisited(i: Int, j: Int) = moveTime[i][j] == -1

        fun isValid(i: Int, j: Int) = i in moveTime.indices && j in moveTime[i].indices

        val offsetX = intArrayOf(0, 0, -1, 1)
        val offsetY = intArrayOf(-1, 1, 0, 0)

        data class Cell(val i: Int, val j: Int, val time: Int, val cost: Int)

        val comparator = Comparator<Cell> { a, b -> (a.time + a.cost) - (b.time + b.cost) }
        val queue = PriorityQueue(comparator)
        queue.add(Cell(0, 0, 0, 1))
        moveTime[0][0] = -1

        while (queue.isNotEmpty()) {
            val (i, j, time, cost) = queue.poll()
            if (isLast(i, j)) {
                return time
            }

            for (o in offsetX.indices) {
                val nextI = i + offsetX[o]
                val nextJ = j + offsetY[o]

                if (isValid(nextI, nextJ) && !isVisited(nextI, nextJ)) {
                    val nextTime = max(time, moveTime[nextI][nextJ]) + cost
                    val nextCost = if (cost == 1) 2 else 1
                    queue.add(Cell(nextI, nextJ, nextTime, nextCost))
                    moveTime[nextI][nextJ] = -1
                }
            }
        }

        // should never happen
        return -1
    }
}