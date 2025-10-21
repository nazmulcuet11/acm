package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode3346 {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        val n = nums.size
        val freq = mutableMapOf<Int, Int>()
        val startPoints = mutableListOf<Int>()
        val endPoints = mutableListOf<Int>()
        val allPoints = mutableListOf<Int>()

        for (x in nums) {
            freq[x] = freq.getOrDefault(x, 0) + 1
            startPoints.add(x - k)
            endPoints.add(x + k)
            allPoints.add(x - k)
            allPoints.add(x)
            allPoints.add(x + k)
        }

        startPoints.sort()
        endPoints.sort()
        allPoints.sort()

        var startCount = 0
        fun startCountBeforeOrEqual(x: Int): Int {
            while (startCount < startPoints.size && startPoints[startCount] <= x) startCount++
            return startCount
        }

        var endCount = 0
        fun endCountBefore(x: Int): Int {
            while (endCount < endPoints.size && endPoints[endCount] < x) endCount++
            return endCount
        }

        fun countOverlappingAt(x: Int): Int {
            val sc = startCountBeforeOrEqual(x)
            val ec = endCountBefore(x)
            return sc - ec
        }

        var ans = 0
        for (p in allPoints) {
            val c = countOverlappingAt(p)
            val f = freq.getOrDefault(p, 0)
            ans = max(ans, min(numOperations, c - f) + f)
        }

        return ans
    }
}