package leetcode

class LeetCode1980 {
    private val existing = mutableSetOf<String>()

    private fun generate(
        n: Int,
        ans: StringBuilder
    ): Boolean {
        if (ans.length == n) {
            return !existing.contains(ans.toString())
        }

        for (c in '0'..'1') {
            ans.append(c)
            if (generate(n, ans)) {
                return true
            }
            ans.setLength(ans.length - 1)
        }
        return false
    }

    fun findDifferentBinaryString(nums: Array<String>): String {
        for (n in nums) {
            existing.add(n)
        }

        val ans = StringBuilder()
        generate(nums.first().length, ans)
        return ans.toString()
    }
}