package leetcode

/*
class LeetCode3208 {
    private fun isCompleteCycle(colors: IntArray): Boolean {
        for (i in 1..<colors.size) {
            if (colors[i] == colors[i - 1]) {
                return false
            }
        }
        return colors.last() != colors.first()
    }

    private fun findStartingPoint(colors: IntArray): Int {
        for (i in 1..<colors.size) {
            if (colors[i] == colors[i - 1]) {
                return i
            }
        }
        return 0
    }

    private fun findChainLength(colors: IntArray, start: Int): Int {
        var prev = colors[start]
        var len = 1
        var i = (start + 1) % colors.size
        while (colors[i] != prev) {
            prev = colors[i]
            len++
            i = (i + 1) % colors.size
        }
        return len
    }

    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        if (isCompleteCycle(colors)) {
            return colors.size
        }

        val start = findStartingPoint(colors)
        var ans = 0
        var i = start
        while (true) {
            val len = findChainLength(colors, i)
            if (len >= k) {
                ans += (len - k) + 1
            }
            if ((i + len) % colors.size == start || (i < start && (i + len) % colors.size > start)) {
                break
            }
            i = (i + len) % colors.size
        }
        return ans
    }
}
*/

class LeetCode3208 {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val expandedColors = colors.toList() + colors.copyOfRange(0, k - 1).toList()

        var ans = 0
        var i = 0
        var j = 1

        while (j < expandedColors.size) {
            if (expandedColors[j] == expandedColors[j - 1]) {
                i = j
            }
            j++
            if (j - i >= k) {
                ans++
                i++
            }
        }
        return ans
    }
}