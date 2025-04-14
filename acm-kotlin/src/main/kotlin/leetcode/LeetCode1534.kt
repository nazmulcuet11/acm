package leetcode

import kotlin.math.abs

class LeetCode1534 {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var count = 0
        for(i in 0..<arr.size) {
            for (j in i + 1..<arr.size) {
                for (k in j + 1..<arr.size) {
                    if (abs(arr[i] - arr[j]) <= a && abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c) {
                        count++
                    }
                }
            }
        }
        return count
    }
}