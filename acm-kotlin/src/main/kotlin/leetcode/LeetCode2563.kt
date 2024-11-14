package leetcode

/*
class LeetCode2563 {
    private var numbers = listOf<Int>()

    private fun lowerBound(n: Int, s: Int): Int {
        var l = s
        var h = numbers.size - 1
        while (l < h) {
            val m = (l + h) / 2
            if (numbers[m] < n) {
                l = m + 1
            } else {
                h = m
            }
        }
        return l
    }

    private fun upperBound(n: Int, s: Int): Int {
        var l = s
        var h = numbers.size - 1
        while (l < h) {
            val m = (l + h + 1) / 2
            if (numbers[m] > n) {
                h = m - 1
            } else {
                l = m
            }
        }
        return l
    }

    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        numbers = nums.sorted()
        var ans = 0L
        for (i in 0..<numbers.size - 1) {
            val x = lowerBound(lower - numbers[i], i + 1)
            val y = upperBound(upper - numbers[i], i + 1)
            if (numbers[i] + numbers[x] in lower..upper &&
                numbers[i] + numbers[y] in lower..upper) {
                ans += (y - x + 1)
            }
        }
        return ans
    }
}
*/

class LeetCode2563 {
    private fun lowerBound(nums: IntArray, n: Int, s: Int): Int {
        var l = s
        var h = nums.size - 1
        while (l <= h) {
            val m = (l + h) / 2
            if (nums[m] < n) {
                l = m + 1
            } else {
                h = m - 1
            }
        }
        return l
    }

    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()
        var ans = 0L
        for (i in 0..<nums.size - 1) {
            val x = lowerBound(nums ,lower - nums[i], i + 1)
            val y = lowerBound(nums, upper - nums[i] + 1, i + 1)
            ans += (y - x)
        }
        return ans
    }
}