package leetcode

class LeetCode983 {
    private var days = intArrayOf()
    private var costs = intArrayOf()
    private val cache = IntArray(370) { -1 }

    private fun next(i: Int, offset: Int): Int {
        var j = i
        while (j < days.size && days[j] <= days[i] + offset - 1) {
            j++
        }
        return j
    }

    private fun solve(i: Int): Int {
        if (i >= days.size) {
            return 0
        }

        if (cache[i] != -1) {
            return cache[i]
        }

        val a = solve(next(i, 1)) + costs[0]
        val b = solve(next(i, 7)) + costs[1]
        val c = solve(next(i, 30)) + costs[2]
        cache[i] = minOf(a, b, c)
        return cache[i]
    }

    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        this.days = days
        this.costs = costs
        return solve(0)
    }
}