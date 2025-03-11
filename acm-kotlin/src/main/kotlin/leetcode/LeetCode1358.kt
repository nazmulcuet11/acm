package leetcode

class LeetCode1358 {
    fun numberOfSubstrings(s: String): Int {
        val count = mutableMapOf<Char, Int>()
        fun getCount(c: Char) = count.getOrDefault(c, 0)
        fun isValid(): Boolean {
            return getCount('a') > 0 && getCount('b') > 0 && getCount('c') > 0
        }
        var ans = 0
        var i = 0
        var j = 0
        while (j < s.length) {
            count[s[j]] = getCount(s[j]) + 1

            while (isValid()) {
                ans += s.length - j
                count[s[i]] = getCount(s[i]) - 1
                i++
            }
            j++
        }
        return ans
    }
}