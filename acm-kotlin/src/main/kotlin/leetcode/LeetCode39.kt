package leetcode

class LeetCode39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return combinationSum(candidates, 0, target, listOf())
    }

    private fun combinationSum(
        candidates: IntArray,
        i: Int,
        target: Int,
        current: List<Int>
    ): List<List<Int>> {
        if (target == 0) {
            return listOf(current.toList())
        }

        val ans: MutableList<List<Int>> = mutableListOf()
        for (j in i..<candidates.size) {
            if (target - candidates[j] >= 0) {
                ans += combinationSum(
                    candidates,
                    j,
                    target - candidates[j],
                    current + listOf(candidates[j])
                )
            }
        }
        return ans
    }
}