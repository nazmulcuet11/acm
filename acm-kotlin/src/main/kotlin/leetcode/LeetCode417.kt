package leetcode

class LeetCode417 {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size

        data class Cell(val x: Int, val y: Int) {
            fun adjacentCells() = listOf(
                Cell(x - 1, y),
                Cell(x, y - 1),
                Cell(x + 1, y),
                Cell(x, y + 1),
            )

            fun isValid() = x in 0..<m && y in 0..<n
        }

        fun bfs(initialCells: List<Cell>): List<List<Boolean>> {
            val queue = ArrayDeque<Cell>()
            val visited = List(m) { MutableList(n) { false } }
            for (cell in initialCells) {
                queue.add(cell)
                visited[cell.x][cell.y] = true
            }

            while (queue.isNotEmpty()) {
                val cell = queue.removeFirst()
                for (neighbor in cell.adjacentCells()) {
                    if (!neighbor.isValid()) {
                        continue
                    }

                    if (visited[neighbor.x][neighbor.y]) {
                        continue
                    }

                    if (heights[neighbor.x][neighbor.y] >= heights[cell.x][cell.y]) {
                        queue.add(neighbor)
                        visited[neighbor.x][neighbor.y] = true
                    }
                }
            }
            return visited
        }

        val firstRow = (0..<n).map { Cell(0, it) }
        val firstColumn = (0..<m).map { Cell(it, 0) }
        val lastRow = (0..<n).map { Cell(m - 1, it) }
        val lastColumn = (0..<m).map { Cell(it, n - 1) }

        val pacific = bfs(firstRow + firstColumn)
        val atlantic = bfs(lastRow + lastColumn)

        val ans = mutableListOf<List<Int>>()
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(listOf(i, j))
                }
            }
        }

        return ans
    }
}