package leetcode

import java.util.*
import kotlin.math.max

class LeetCode42 {
    private data class Node(val x: Int, val h: Int)

    private val moves = listOf(-1, 1)
    private val comparator = Comparator<Node> { a, b -> a.h - b.h }

    fun trap(height: IntArray): Int {
        val n = height.size
        val q = PriorityQueue<Node>(comparator)
        val visited = BooleanArray(n) { false }
        var ans = 0
        // insert boundary in queue
        q.add(Node(0, height[0]))
        visited[0] = true
        q.add(Node(n - 1, height[n - 1]))
        visited[n - 1] = true

        while (q.isNotEmpty()) {
            val t = q.poll()
            for (d in moves) {
                val nx = t.x + d
                if (nx in 0..<n && !visited[nx]) {
                    ans += max(t.h - height[nx], 0)
                    q.add(Node(nx, max(t.h, height[nx])))
                    visited[nx] = true
                }
            }
        }
        return ans
    }
}