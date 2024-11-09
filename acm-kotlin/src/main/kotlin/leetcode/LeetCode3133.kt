package leetcode

class LeetCode3133 {
    fun minEnd(n: Int, x: Int): Long {
        var ans = x.toLong()
        var t = (n - 1).toLong()
        var i = 0
        while (t > 0) {
            if (ans and (1L shl i) == 0L) {
                ans = ans or ((t and 1) shl i)
                t = t shr 1
            }
            i++
        }
        return ans
    }
}