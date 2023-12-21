package leetcode

class LeetCode39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return combinationSum(candidates.toList(), target, listOf())
    }

    private fun combinationSum(
        candidates: List<Int>,
        target: Int,
        current: List<Int>
    ): List<List<Int>> {
        if (target == 0) {
            return listOf(current.toList())
        }

        return candidates.indices
            .filter { target - candidates[it] >= 0 }
            .flatMap {
                combinationSum(
                    candidates.drop(it),
                    target - candidates[it],
                    current + listOf(candidates[it])
                )
            }
    }
}