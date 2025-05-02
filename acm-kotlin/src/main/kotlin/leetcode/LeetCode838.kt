package leetcode

class LeetCode838 {
    fun pushDominoes(dominoes: String): String {
        val state = StringBuilder(dominoes)
        val queue = ArrayDeque<Int>()

        // Initialize queue with indices of pushed dominoes
        for ((i, ch) in dominoes.withIndex()) {
            if (ch == 'L' || ch == 'R') {
                queue.addLast(i)
            }
        }

        while (queue.isNotEmpty()) {
            val nextQueue = ArrayDeque<Int>()
            val pendingUpdates = mutableMapOf<Int, Char>()

            while (queue.isNotEmpty()) {
                val index = queue.removeFirst()
                val direction = state[index]
                val target = if (direction == 'L') index - 1 else index + 1

                // Skip if target is out of bounds or already set
                if (target !in state.indices || state[target] != '.') continue

                if (direction == 'L') {
                    val leftNeighbor = target - 1
                    if (leftNeighbor < 0 || state[leftNeighbor] != 'R') {
                        pendingUpdates[target] = 'L'
                        nextQueue.add(target)
                    }
                } else if (direction == 'R') {
                    val rightNeighbor = target + 1
                    if (rightNeighbor >= state.length || state[rightNeighbor] != 'L') {
                        pendingUpdates[target] = 'R'
                        nextQueue.add(target)
                    }
                }
            }

            // Apply the updates for this tick
            for ((i, ch) in pendingUpdates) {
                state[i] = ch
            }

            queue.addAll(nextQueue)
        }

        return state.toString()
    }
}