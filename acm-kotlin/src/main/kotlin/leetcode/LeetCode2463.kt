package leetcode

import kotlin.math.abs
import kotlin.math.min

class LeetCode2463 {
    companion object {
        const val INFINITY = 1000_000_000_000L
    }

    private var robots = listOf<Int>()
    private var factories = listOf<Int>()
    private var cache = mutableMapOf<String, Long>()

    private fun solve(i: Int, j: Int): Long {
        if (i < 0) {
            return 0
        }

        if (j < 0) {
            return INFINITY
        }

        val key = "$i,$j"
        cache[key]?.let {
            return it
        }

        val ans = min(
            solve(i, j - 1),
            solve(i - 1, j - 1) + abs(robots[i] - factories[j])
        )
        cache[key] = ans
        return ans
    }

    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        this.robots = robot.sorted()
        val factories = mutableListOf<Int>()
        for (f in factory) {
            for (j in 0..<f[1]) {
                factories.add(f[0])
            }
        }
        this.factories = factories.sorted()
        return solve(robots.size - 1, factories.size - 1)
    }
}