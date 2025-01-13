package leetcode

class LeetCode3223 {
    fun minimumLength(s: String): Int {
        val charCount = mutableMapOf<Char, Int>()
        for (c in s) {
            charCount[c] = charCount.getOrDefault(c, 0) + 1
        }

        var ans = 0
        for ((_, v) in charCount) {
//            var t = v
//            while (t >= 3) {
//                t -= 2
//            }
//            ans += t
            ans += if (v % 2 == 0) 2 else 1
        }
        return ans
    }
}