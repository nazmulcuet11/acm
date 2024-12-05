package leetcode

class LeetCode2337 {
    fun canChange(start: String, target: String): Boolean {
        if (start.replace("_", "") != target.replace("_", "")) return false

        var i = 0
        var j = 0
        while (i < start.length && j < target.length) {
            while (i < start.length && start[i] == '_') {
                i++
            }

            while (j < target.length && target[j] == '_') {
                j++
            }

            if (i >= start.length || j >= target.length) {
                break
            }

            if (start[i] != target[j]) {
                return false
            }

            if (start[i] == 'L' && i < j) {
                return false
            }

            if (start[i] == 'R' && i > j) {
                return false
            }

            i++
            j++
        }
        return true
    }
}
