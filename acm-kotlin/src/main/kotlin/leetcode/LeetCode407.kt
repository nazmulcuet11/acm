package leetcode

import java.util.*
import kotlin.math.max

class LeetCode407 {
    private data class Node(val x: Int, val y: Int, val h: Int)
    private data class Move(val x: Int, val y: Int)

    private val moves = listOf(
        Move(0, 1),
        Move(0, -1),
        Move(1, 0),
        Move(-1, 0)
    )
    private val comparator = Comparator<Node> { a, b -> a.h - b.h }

    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val m = heightMap.size
        val n = heightMap.first().size
        val q = PriorityQueue<Node>(comparator)
        val visited = Array(m) { BooleanArray(n) { false } }
        var ans = 0
        // insert boundary in queue
        for (j in 0..<n) {
            // first row
            q.add(Node(0, j, heightMap[0][j]))
            visited[0][j] = true
            // last row
            q.add(Node(m - 1, j, heightMap[m - 1][j]))
            visited[m - 1][j] = true
        }
        for (i in 1..<m - 1) {
            // first column
            q.add(Node(i, 0, heightMap[i][0]))
            visited[i][0] = true
            // last column
            q.add(Node(i, n - 1, heightMap[i][n - 1]))
            visited[i][n - 1] = true
        }

        while (q.isNotEmpty()) {
            val t = q.poll()
            for (d in moves) {
                val nx = t.x + d.x
                val ny = t.y + d.y
                if (nx in 0..<m && ny in 0..<n && !visited[nx][ny]) {
                    ans += max(t.h - heightMap[nx][ny], 0)
                    q.add(Node(nx, ny, max(t.h, heightMap[nx][ny])))
                    visited[nx][ny] = true
                }
            }
        }
        return ans
    }
}