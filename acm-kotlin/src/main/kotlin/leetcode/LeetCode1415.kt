package leetcode

class LeetCode1415 {
    private val happyStrings = mutableListOf<String>()

    private fun generate(n: Int, curr: String) {
        if (curr.length == n) {
            happyStrings.add(curr)
            return
        }

        for (c in 'a'..'c') {
            if (curr.isEmpty() || curr.last() != c) {
                generate(n, curr + c)
            }
        }
    }

    fun getHappyString(n: Int, k: Int): String {
        generate(n, "")
        if (k > happyStrings.size) {
            return ""
        }
        return happyStrings[k - 1]
    }
}