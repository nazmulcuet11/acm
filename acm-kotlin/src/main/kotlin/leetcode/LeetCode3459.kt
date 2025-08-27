package leetcode

import kotlin.math.max

class LeetCode3459 {
    enum class Direction(val value: Int) {
        TOP_LEFT(0),
        TOP_RIGHT(1),
        BOTTOM_LEFT(2),
        BOTTOM_RIGHT(3),
    }

    fun lenOfVDiagonal(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val directions = setOf(
            Direction.TOP_LEFT,
            Direction.TOP_RIGHT,
            Direction.BOTTOM_LEFT,
            Direction.BOTTOM_RIGHT,
        )

        fun nextTarget(target: Int): Int {
            return if (target == 0 || target == 1) {
                2
            } else {
                0
            }
        }

        fun nextI(i: Int, direction: Direction): Int {
            return when (direction) {
                Direction.TOP_LEFT, Direction.TOP_RIGHT -> i - 1
                Direction.BOTTOM_LEFT, Direction.BOTTOM_RIGHT -> i + 1
            }
        }

        fun nextJ(j: Int, direction: Direction): Int {
            return when (direction) {
                Direction.TOP_LEFT, Direction.BOTTOM_LEFT -> j - 1
                Direction.TOP_RIGHT, Direction.BOTTOM_RIGHT -> j + 1
            }
        }

        fun nextDirection(direction: Direction): Direction {
            return when (direction) {
                Direction.TOP_LEFT -> Direction.TOP_RIGHT
                Direction.BOTTOM_LEFT -> Direction.TOP_LEFT
                Direction.TOP_RIGHT -> Direction.BOTTOM_RIGHT
                Direction.BOTTOM_RIGHT -> Direction.BOTTOM_LEFT
            }
        }


        val cache = Array(4) { Array(m) { Array(n) { Array(2) { -1 } } }}
        fun walk(d: Direction,  i: Int, j: Int, turn: Int, target: Int): Int {
            if (!(i in 0..<m && j in 0..<n)) {
                return 0
            }

            if (grid[i][j] != target) {
                return 0
            }

            if (cache[d.value][i][j][turn] != -1) {
                return cache[d.value][i][j][turn]
            }

            val a = walk(d, nextI(i, d), nextJ(j, d), turn, nextTarget(target)) + 1
            val b = if (turn > 0) {
                walk(nextDirection(d), i, j, turn - 1, target)
            } else {
                0
            }
            val ans = max(a, b)
            cache[d.value][i][j][turn] = ans
            return ans
        }

        var ans = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] == 1) {
                    for (direction in directions) {
                        ans = max(ans, walk(direction, i, j, 1, 1))
                    }
                }
            }
        }

        return ans
    }
}