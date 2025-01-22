package leetcode

class LeetCode1765 {
    private data class Index(val i: Int, val j: Int)
    private data class Move(val x: Int, val y: Int)

    private val moves = listOf(
        Move(0, -1),
        Move(-1, 0),
        Move(1, 0),
        Move(0, 1),
    )

    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val m = isWater.size
        val n = isWater[0].size

        // set land as -1
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (isWater[i][j] == 0) {
                    isWater[i][j] = -1
                }
            }
        }

        // set water as 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0
                }
            }
        }

        val q = ArrayDeque<Index>()
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (isWater[i][j] == 0) {
                    q.add(Index(i, j))
                }
            }
        }

        while (q.isNotEmpty()) {
            val t = q.removeFirst()
            for (d in moves) {
                val ni = t.i + d.x
                val nj = t.j + d.y
                if (ni in 0..<m && nj in 0..<n && isWater[ni][nj] == -1) {
                    isWater[ni][nj] = isWater[t.i][t.j] + 1
                    q.add(Index(ni, nj))
                }
            }
        }

        return isWater
    }
}