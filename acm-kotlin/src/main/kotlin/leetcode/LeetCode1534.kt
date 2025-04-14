package leetcode

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class LeetCode1534 {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var count = 0
        val prefixCount = IntArray(1002) { 0 }
        for (j in arr.indices) {
            for (k in j + 1..<arr.size) {
                if (abs(arr[j] - arr[k]) <= b) {
                    val l = max(0, max(arr[j] - a, arr[k] - c))
                    val r = min(1000, min(arr[j] + a, arr[k] + c))
                    if (l <= r) {
                        count += if (l > 0) {
                            prefixCount[r] - prefixCount[l - 1]
                        } else {
                            prefixCount[r]
                        }
                    }
                }
            }

            for (k in arr[j]..1000) {
                prefixCount[k]++
            }
        }
        return count
    }
}