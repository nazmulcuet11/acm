package leetcode

class LeetCode1524 {
    companion object {
        const val MOD = 1000_000_000 + 7
    }

    fun numOfSubarrays(arr: IntArray): Int {
        for (i in 1..<arr.size) {
            arr[i] += arr[i - 1]
        }

        val oddCount = IntArray(arr.size) { 0 }
        val evenCount = IntArray(arr.size) { 0 }
        for (i in arr.size - 1 downTo 0) {
            if (arr[i] % 2 == 0) {
                evenCount[i]++
            } else {
                oddCount[i]++
            }

            if (i < arr.size - 1) {
                evenCount[i] += evenCount[i + 1]
                oddCount[i] += oddCount[i + 1]
            }
        }

        var ans = 0
        for (i in arr.indices) {
            ans += if (i == 0 || arr[i - 1] % 2 == 0) {
                oddCount[i] % MOD
            } else {
                evenCount[i] % MOD
            }
            ans %= MOD
        }
        return ans
    }
}