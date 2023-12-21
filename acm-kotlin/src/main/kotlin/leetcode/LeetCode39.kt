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

        return (i..<candidates.size)
            .filter { target - candidates[it] >= 0 }
            .flatMap {
                combinationSum(
                    candidates,
                    it,
                    target - candidates[it],
                    current + listOf(candidates[it])
                )
            }
    }
}