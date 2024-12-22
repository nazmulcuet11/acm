package leetcode.weekly429

import kotlin.math.max
import kotlin.math.min

class Question2 {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        val count = mutableMapOf<Int, Int>()
        fun getCount(i: Int) = count.getOrDefault(i, 0)

        for (n in nums) {
            count[n] = getCount(n) + 1
        }

        var ans = 0
        val keys = count.keys.sorted()
        var lastRangeEnd = keys[0] - k - 5
        for (x in keys) {
            val rangeMin = max(lastRangeEnd + 1, x - k)
            val rangeMax = x + k
            val maxNumberOfValuesCanBePickedInRange = getCount(x)
            val numberOfValuesInRange = rangeMax - rangeMin + 1
            val numberOfValuesPickedInRange = min(maxNumberOfValuesCanBePickedInRange, numberOfValuesInRange)
            ans += numberOfValuesPickedInRange
            lastRangeEnd = rangeMin + numberOfValuesPickedInRange - 1
        }
        return ans
    }
}