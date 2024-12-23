package leetcode

class LeetCode2257 {
    fun countUnguarded(
        m: Int,
        n: Int,
        guards: Array<IntArray>,
        walls: Array<IntArray>
    ): Int {
        val grid = Array(m) {
            Array(n) { '*' }
        }
        for (guard in guards) {
            grid[guard[0]][guard[1]] = 'g'
        }
        for (wall in walls) {
            grid[wall[0]][wall[1]] = 'w'
        }

        fun visit(
            initialX: Int,
            initialY: Int,
            deltaX: Int,
            deltaY: Int,
        ) {
            var x = initialX
            var y = initialY
            while (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 'g' && grid[x][y] != 'w') {
                grid[x][y] = 'v'
                x += deltaX
                y += deltaY
            }
        }

        for (guard in guards) {
            // go top
            visit(guard[0] - 1, guard[1], -1, 0)
            // go down
            visit(guard[0] + 1, guard[1], 1, 0)
            // go left
            visit(guard[0], guard[1] - 1, 0, -1)
            // go right
            visit(guard[0], guard[1] + 1, 0, 1)
        }

        var count = 0
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (grid[i][j] == '*') {
                    count++
                }
            }
        }
        return count
    }
}