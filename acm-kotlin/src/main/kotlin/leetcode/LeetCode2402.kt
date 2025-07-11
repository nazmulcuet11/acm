package leetcode

import java.util.*
import kotlin.math.max

class LeetCode2402 {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val roomToMeetingCount = IntArray(n) { 0 }

        meetings.sortBy { it[0] }

        val availableRooms = PriorityQueue<Int>()
        for (room in 0..<n) {
            availableRooms.add(room)
        }

        data class OngoingMeeting(val room: Int, val start: Long, val end: Long)

        val ongoingMeetings = PriorityQueue<OngoingMeeting>(compareBy { it.end })

        var time = 0L
        var i = 0

        fun dequeue() {
            while (ongoingMeetings.isNotEmpty() && ongoingMeetings.peek().end <= time) {
                val ongoingMeeting = ongoingMeetings.poll()
                availableRooms.add(ongoingMeeting.room)
            }
        }

        fun enqueue() {
            while (i < meetings.size) {
                time = max(time, meetings[i][0].toLong())
                dequeue()
                if (availableRooms.isNotEmpty()) {
                    val room = availableRooms.poll()
                    roomToMeetingCount[room]++
                    val duration = meetings[i][1] - meetings[i][0]
                    val ongoingMeeting = OngoingMeeting(room, time, time + duration)
                    ongoingMeetings.add(ongoingMeeting)
                    i++
                } else {
                    break
                }
            }
        }

        while (i < meetings.size) {
            enqueue()
            time = max(time, ongoingMeetings.peek().end)
            dequeue()
        }

        var ans = 0
        for (room in 0..<n) {
            if (roomToMeetingCount[room] > roomToMeetingCount[ans]) {
                ans = room
            }
        }
        return ans
    }
}