package leetcode

import java.util.*

class LeetCode2071 {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        // Custom multiset using TreeMap to support duplicates and ceiling queries
        class SortedMultiSet {
            private val map = TreeMap<Int, Int>()

            fun add(x: Int) {
                map[x] = map.getOrDefault(x, 0) + 1
            }

            fun remove(x: Int) {
                val count = map[x] ?: return
                if (count == 1) map.remove(x)
                else map[x] = count - 1
            }

            fun ceil(k: Int): Int? = map.ceilingKey(k)
        }

        // Sort tasks in increasing difficulty and workers in decreasing strength
        tasks.sort()
        workers.sortDescending()

        // Check if we can assign k tasks to k workers using available pills and strength boost.
        // We greedily select the k easiest tasks and try to assign them to the k strongest workers.
        fun verify(k: Int): Boolean {
            // Take k easiest tasks, process them from hardest to easiest among them
            val tasksList = tasks.take(k).reversed()

            var remainingPills = pills
            val workersSet = SortedMultiSet()

            // Add the k strongest workers to the multiset
            workers.take(k).forEach { workersSet.add(it) }

            for (task in tasksList) {
                // First, try to find a worker who can do the task without a pill
                val directWorker = workersSet.ceil(task)
                if (directWorker != null) {
                    workersSet.remove(directWorker)
                    continue
                }

                // If not possible, try to use a pill on a weaker worker
                if (remainingPills > 0) {
                    val boostedWorker = workersSet.ceil(task - strength)
                    if (boostedWorker != null) {
                        workersSet.remove(boostedWorker)
                        remainingPills--
                        continue
                    }
                }

                // No valid worker found even with a pill
                return false
            }

            return true // All tasks assigned successfully
        }

        // Binary search the maximum number of tasks that can be assigned
        var low = 0
        var high = tasks.size
        while (low < high) {
            val mid = (low + high + 1) / 2
            if (verify(mid)) {
                low = mid
            } else {
                high = mid - 1
            }
        }

        return low
    }
}