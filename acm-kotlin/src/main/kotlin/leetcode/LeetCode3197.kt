package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3197 {
    fun minimumSum(grid: Array<IntArray>): Int {
        data class Rectangle(val minX: Int, val minY: Int, val maxX: Int, val maxY: Int) {
            fun area(): Int {
                return if (minX <= maxX && minY <= maxY) {
                    (maxX - minX + 1) * (maxY - minY + 1)
                } else {
                    0
                }
            }
        }

        fun shrink(rect: Rectangle): Rectangle {
            var newMinX = rect.maxX
            var newMinY = rect.maxY
            var newMaxX = rect.minX
            var newMaxY = rect.minY

            for (i in rect.minX..rect.maxX) {
                for (j in rect.minY..rect.maxY) {
                    if (grid[i][j] == 1) {
                        newMinX = min(newMinX, i)
                        newMaxX = max(newMaxX, i)
                        newMinY = min(newMinY, j)
                        newMaxY = max(newMaxY, j)
                    }
                }
            }

            return Rectangle(
                newMinX,
                newMinY,
                newMaxX,
                newMaxY
            )
        }

        fun partition(rect: Rectangle, rem: Int): Int {
            if (rem == 1) {
                return shrink(rect).area()
            } else if (rem == 2) {
                var ans = shrink(rect).area()

                // = pattern
                for (i in rect.minX..<rect.maxX) {
                    val region1 = Rectangle(rect.minX, rect.minY, i, rect.maxY)
                    val region2 = Rectangle(i + 1, rect.minY, rect.maxX, rect.maxY)
                    ans = min(ans, shrink(region1).area() + shrink(region2).area())
                }

                // || pattern
                for (j in rect.minY..<rect.maxY) {
                    val region1 = Rectangle(rect.minX, rect.minY, rect.maxX, j)
                    val region2 = Rectangle(rect.minX, j + 1, rect.maxX, rect.maxY)
                    ans = min(ans, shrink(region1).area() + shrink(region2).area())
                }

                return ans
            } else {
                var ans = shrink(rect).area()

                // = pattern
                for (i in rect.minX..<rect.maxX) {
                    val region1 = Rectangle(rect.minX, rect.minY, i, rect.maxY)
                    val region2 = Rectangle(i + 1, rect.minY, rect.maxX, rect.maxY)
                    ans = min(ans, shrink(region1).area() + partition(region2, 2))
                    ans = min(ans, partition(region1, 2) + shrink(region2).area())
                }

                // || pattern
                for (j in rect.minY..<rect.maxY) {
                    val region1 = Rectangle(rect.minX, rect.minY, rect.maxX, j)
                    val region2 = Rectangle(rect.minX, j + 1, rect.maxX, rect.maxY)
                    ans = min(ans, shrink(region1).area() + partition(region2, 2))
                    ans = min(ans, partition(region1, 2) + shrink(region2).area())
                }

                return ans
            }
        }


        val m = grid.size
        val n = grid[0].size

        val wholeGridRect = Rectangle(0, 0, m - 1, n - 1)
        val rectCoveringAllOnes = shrink(wholeGridRect)
        val ans = partition(rectCoveringAllOnes, 3)
        return ans
    }
}