package leetcode

class LeetCode2109 {
    fun addSpaces(s: String, spaces: IntArray): String {
        var x = 0
        val ans = StringBuilder()
        for ((i, ch) in s.withIndex()) {
            if (x < spaces.size && i == spaces[x]) {
                ans.append(' ')
                x++
            }
            ans.append(ch)
        }
        return ans.toString()
    }
}
