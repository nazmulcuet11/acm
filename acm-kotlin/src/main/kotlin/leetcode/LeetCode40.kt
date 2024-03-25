package leetcode

class LeetCode40 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val candidateCountMap = mutableMapOf<Int, Int>()
        for (candidate in candidates) {
            candidateCountMap[candidate] = candidateCountMap.getOrDefault(candidate, 0) + 1
        }
        return combinationSum(
            candidateCountMap.map { Pair(it.key, it.value) },
            target,
            listOf(),
        )
    }

    private fun combinationSum(
        candidates: List<Pair<Int, Int>>,
        target: Int,
        current: List<Int>
    ): List<List<Int>> {
        if (target == 0) {
            return listOf(current.toList())
        }

        val ans = mutableListOf<List<Int>>()
        for (i in 0..<candidates.count()) {
            val (candidate, count) = candidates[i]
            for (c in 1..count) {
                if (target - candidate * c >= 0) {
                    ans += combinationSum(
                        candidates.drop(i + 1),
                        target - candidate * c,
                        current + (1..c).map { candidate }
                    )
                }
            }
        }
        return ans
    }
}