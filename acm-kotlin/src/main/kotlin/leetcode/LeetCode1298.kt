package leetcode

class LeetCode1298 {
    fun maxCandies(
        status: IntArray,
        candies: IntArray,
        keys: Array<IntArray>,
        containedBoxes: Array<IntArray>,
        initialBoxes: IntArray
    ): Int {
        val n = status.size
        val available = BooleanArray(n) { false }
        val processed = BooleanArray(n) { false }
        val queue = ArrayDeque<Int>()
        for (b in initialBoxes) {
            available[b] = true
            if (status[b] == 1) {
                queue.add(b)
                processed[b] = true
            }
        }

        var ans = 0
        while (queue.isNotEmpty()) {
            val b = queue.removeFirst()
            ans += candies[b]

            for (cb in containedBoxes[b]) {
                available[cb] = true
                if (status[cb] == 1 && !processed[cb]) {
                    queue.add(cb)
                    processed[cb] = true
                }
            }

            for (k in keys[b]) {
                status[k] = 1
                if (available[k] && !processed[k]) {
                    queue.add(k)
                    processed[k] = true
                }
            }
        }
        return ans
    }
}