package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LeetCode3408Tests {
    @Test
    fun case1() {
        val results = mutableListOf<Any?>()

        val manager = LeetCode3408.TaskManager(
            listOf(
                listOf(20, 55, 91),
                listOf(30, 94, 511),
                listOf(35, 90, 877),
                listOf(40, 57, 281),
                listOf(33, 11, 408),
                listOf(13, 91, 217),
                listOf(31, 95, 239),
                listOf(8, 51, 132),
                listOf(42, 77, 30),
                listOf(20, 36, 894),
                listOf(12, 15, 43),
                listOf(1, 48, 591),
                listOf(22, 85, 420),
                listOf(21, 83, 767),
                listOf(6, 25, 894),
                listOf(38, 38, 722),
                listOf(42, 65, 579),
                listOf(47, 54, 436),
                listOf(37, 45, 483),
                listOf(27, 74, 712),
                listOf(23, 63, 610),
                listOf(48, 24, 843),
                listOf(26, 81, 742),
                listOf(41, 78, 625),
                listOf(27, 75, 506),
                listOf(13, 70, 121),
                listOf(24, 6, 103),
            )
        )
        results.add(null) // TaskManager constructor

        manager.add(12, 71, 260); results.add(null)
        manager.add(26, 30, 626); results.add(null)
        manager.add(1, 68, 206); results.add(null)

        manager.edit(55, 566); results.add(null)
        manager.edit(6, 312); results.add(null)
        manager.edit(36, 919); results.add(null)
        manager.edit(95, 720); results.add(null)

        manager.rmv(55); results.add(null)

        manager.add(9, 29, 635); results.add(null)
        manager.edit(54, 450); results.add(null)

        results.add(manager.execTop()) // expect 20

        manager.rmv(90); results.add(null)
        manager.add(28, 82, 378); results.add(null)
        manager.add(21, 66, 569); results.add(null)
        manager.edit(30, 476); results.add(null)
        manager.edit(48, 500); results.add(null)
        manager.rmv(85); results.add(null)
        manager.edit(6, 246); results.add(null)
        manager.rmv(71); results.add(null)

        results.add(manager.execTop()) // expect 6

        manager.add(40, 37, 335); results.add(null)

        results.add(manager.execTop()) // expect 48

        manager.rmv(95); results.add(null)

        results.add(manager.execTop()) // expect 21

        manager.add(21, 67, 174); results.add(null)

        results.add(manager.execTop()) // expect 26
        results.add(manager.execTop()) // expect 38

        manager.rmv(74); results.add(null)
        manager.rmv(63); results.add(null)

        results.add(manager.execTop()) // expect 9
        results.add(manager.execTop()) // expect 41
        results.add(manager.execTop()) // expect 42
        results.add(manager.execTop()) // expect 21

        val expected = listOf<Any?>(
            null,null,null,null,null,null,null,null,null,null,null,
            20,null,null,null,null,null,null,null,null,
            6,null,48,null,21,null,26,38,null,null,9,41,42,21
        )

        assertEquals(expected, results)
    }

    @Test
    fun case2() {
        val results = mutableListOf<Any?>()

        val manager = LeetCode3408.TaskManager(
            listOf(
                listOf(4, 15, 33)
            )
        )
        results.add(null) // TaskManager constructor has no return

        results.add(manager.execTop()) // expect 4

        val expected = listOf<Any?>(
            null, 4
        )

        assertEquals(expected, results)
    }

    @Test
    fun case3() {
        val results = mutableListOf<Any?>()

        val manager = LeetCode3408.TaskManager(
            listOf(
                listOf(2, 26, 15),
                listOf(6, 1, 19)
            )
        )
        results.add(null) // constructor

        manager.edit(26, 15) // edit taskId=26, newPriority=15
        results.add(null)

        results.add(manager.execTop()) // expect 6

        val expected = listOf<Any?>(
            null, null, 6
        )

        assertEquals(expected, results)
    }

}