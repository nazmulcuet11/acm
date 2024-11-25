package leetcode

class LeetCode773 {
    private fun stringify(board: Array<IntArray>): String {
        val sb = StringBuilder()
        for (row in board) {
            for (n in row) {
                sb.append(n.toString())
            }
        }
        return sb.toString()
    }

    private fun stringBySwapping(s: String, i: Int, j: Int): String {
        val sb = StringBuilder()
        s.forEach { sb.append(it) }
        val t = sb[i]
        sb[i] = sb[j]
        sb[j] = t
        return sb.toString()
    }

    private fun nextStates(state: String): List<String> {
        val ns = mutableListOf<String>()
        val i = state.indexOf('0')
        val swapIndices = mapOf(
            0 to intArrayOf(1, 3),
            1 to intArrayOf(0, 2, 4),
            2 to intArrayOf(1, 5),
            3 to intArrayOf(0, 4),
            4 to intArrayOf(1, 3, 5),
            5 to intArrayOf(2, 4),
        )
        for (j in swapIndices[i]!!) {
            ns.add(stringBySwapping(state, i, j))
        }
        return ns
    }

    fun slidingPuzzle(board: Array<IntArray>): Int {
        val initialState = stringify(board)
        val targetState = "123450"
        val cost = mutableMapOf<String, Int>()
        cost[initialState] = 0
        val q = ArrayDeque<String>()
        q.add(initialState)
        while (q.isNotEmpty()) {
            val state = q.removeFirst()
            if (state == targetState) {
                break
            }
            val nextStates = nextStates(state)
            for (nextState in nextStates) {
                if (!cost.containsKey(nextState)) {
                    cost[nextState] = cost[state]!! + 1
                    q.add(nextState)
                }
            }
        }
        return cost.getOrDefault(targetState, -1)
    }
}