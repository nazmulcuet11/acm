package leetcode

import java.util.*
import kotlin.math.max

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

        fun dequeue() {
            while (queue.isNotEmpty()) {
                val event = queue.poll()
                if (day <= event[1]) {
                    ans++
                    day++
                    enqueue()
                }
            }
        }

        enqueue()

        while (i < events.size && day <= maxDay) {
            dequeue()
            if (i < events.size) {
                day = max(day, events[i][0])
                enqueue()
            }
        }

        dequeue()

        return ans
    }
}
