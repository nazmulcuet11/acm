package leetcode

import java.util.PriorityQueue

class LeetCode1353 {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }
        val queue = PriorityQueue<IntArray>(compareBy { it[1] })
        var ans = 0
        val minDay = events[0][0]
        val maxDay = events.last()[1]
        var day = minDay
        var i = 0

        fun enqueue() {
            while (i < events.size && events[i][0] <= day) {
                queue.add(events[i])
                i++
            }
        }

        enqueue()

        while (day < maxDay) {

            while (queue.isNotEmpty()) {
                val event = queue.poll()
                if (day <= event[1]) {
                    ans++
                    day++
                    enqueue()
                }
            }

            day++
            enqueue()
        }

        return ans
    }
}
