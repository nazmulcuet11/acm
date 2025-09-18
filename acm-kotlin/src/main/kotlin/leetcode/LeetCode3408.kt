package leetcode

import java.util.TreeSet

class LeetCode3408 {
    class TaskManager(tasks: List<List<Int>>) {

        data class Task(val userId: Int, val taskId: Int, val priority: Int): Comparable<Task> {
            override operator fun compareTo(other: Task): Int {
                if (priority == other.priority) {
                    return other.taskId.compareTo(taskId)
                }
                return other.priority.compareTo(priority)
            }
        }

        private val treeSet = TreeSet<Task>()
        private val taskIdToTask = mutableMapOf<Int, Task>()

        init {
            for (t in tasks) {
                add(t[0], t[1], t[2])
            }
        }

        fun add(userId: Int, taskId: Int, priority: Int) {
            val task = Task(userId, taskId, priority)
            treeSet.add(task)
            taskIdToTask[taskId] = task
        }

        fun edit(taskId: Int, newPriority: Int) {
            val oldTask = taskIdToTask[taskId] ?: return
            rmv(taskId)
            add(oldTask.userId, taskId, newPriority)
        }

        fun rmv(taskId: Int) {
            val task = taskIdToTask[taskId] ?: return
            treeSet.remove(task)
            taskIdToTask.remove(taskId)
        }

        fun execTop(): Int {
            val task = treeSet.firstOrNull() ?: return -1
            rmv(task.taskId)
            return task.userId
        }
    }
}