package leetcode

class LeetCode38 {
    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }

        val prev = countAndSay(n - 1)
        return countAndSay(prev)
    }

    private fun countAndSay(s: String): String {
        var newValue = ""
        var count = 1
        for (i in 1..s.length) {
            if (i < s.length && s[i] == s[i-1]) {
                count += 1
            } else {
                newValue += "$count${s[i-1]}"
                count = 1
            }
        }
        return newValue
    }
}