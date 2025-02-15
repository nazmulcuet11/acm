package leetcode

class LeetCode2698 {
    private fun canPartition(num: Int, target: Int): Boolean {
        if (num == target) {
            return true
        }

        var t = 10
        while (t <= num) {
            val left = num / t
            val right = num % t
            if (canPartition(right, target - left)) {
                return true
            }
            t *= 10
        }
        return false
    }

    fun punishmentNumber(n: Int): Int {
        var sum = 0
        for (i in 1..n) {
            if (canPartition(i * i, i)) {
                sum += i * i
            }
        }
        return sum
    }
}