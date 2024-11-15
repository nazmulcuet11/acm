package leetcode

import kotlin.math.min

/*
class LeetCode1574 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val n = arr.size
        var ans = n - 1

        // case 1: remove suffix
        var l = 0
        while (l + 1 < n && arr[l] <= arr[l + 1])
            l++
        ans = min(ans, n - l - 1)

        // case 2: remove prefix
        var r = n - 1
        while (r > 0 && arr[r - 1] <= arr[r])
            r--
        ans = min(ans, r)

        if (l >= r) {
            return ans
        }

        // case 3: remove from middle
        var i = 0
        while (i <= l) {
            while (r < n && arr[r] < arr[i])
                r++

            ans = min(ans,r - i - 1)
            i++
        }

        return ans
    }
}
*/

class LeetCode1574 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val n = arr.size
        var ans = n - 1

        var r = n - 1
        while (r > 0 && arr[r - 1] <= arr[r])
            r--
        ans = min(ans, r)

        var l = 0
        while (l < r) {
            while (r < n && arr[r] < arr[l])
                r++

            ans = min(ans,r - l - 1)
            if (arr[l] > arr[l + 1]) {
                break
            }
            l++
        }

        return ans
    }
}