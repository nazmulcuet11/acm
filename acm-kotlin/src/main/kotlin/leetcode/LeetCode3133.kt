package leetcode

class LeetCode3133 {
    fun minEnd(n: Int, x: Int): Long {
        var ans = x.toLong()
        var t = (n - 1).toLong()
        var i = 0
        while (t > 0) {
            while (ans and (1L shl i) > 0)
                i++

            ans = ans or ((t and 1) shl i)
            i++
            t = t shr 1
        }
        return ans
    }
}