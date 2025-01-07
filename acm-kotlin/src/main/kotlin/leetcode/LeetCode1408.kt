package leetcode

class LeetCode1408 {
    fun stringMatching(words: Array<String>): List<String> {
        val ans = mutableListOf<String>()
        for (w in words) {
            for (ow in words) {
                if (ow != w && ow.contains(w)) {
                    ans.add(w)
                    break
                }
            }
        }
        return ans
    }
}