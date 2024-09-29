package leetcode

import kotlin.math.max
import kotlin.math.min

class LeetCode731 {
    private data class Booking(
        val start: Int,
        val end: Int
    )

    private var singleBookings = mutableListOf<Booking>()
    private var doubleBookings = mutableListOf<Booking>()

    private fun overlap(a: Booking, b: Booking): Boolean {
        return !(b.end <= a.start || a.end <= b.start)
    }

    private fun overlap(b: Booking, bookings: List<Booking>): Boolean {
        for (a in bookings) {
            if (overlap(a, b)) {
                return true
            }
        }
        return false
    }

    private fun updateDoubleBookings(b: Booking) {
        for (a in singleBookings) {
            if (overlap(a, b)) {
                doubleBookings.add(Booking(max(a.start, b.start), min(a.end, b.end)))
            }
        }
    }

    fun book(start: Int, end: Int): Boolean {
        val b = Booking(start, end)
        if (overlap(b, doubleBookings)) {
            return false
        }
        updateDoubleBookings(b)
        singleBookings.add(b)
        return true
    }
}
