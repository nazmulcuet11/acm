package leetcode

class LeetCode1462 {
    /*
    fun checkIfPrerequisite(
        numCourses: Int,
        prerequisites: Array<IntArray>,
        queries: Array<IntArray>
    ): List<Boolean> {
        val graph = List(numCourses) { mutableListOf<Int>() }
        for (entry in prerequisites) {
            val u = entry[0]
            val v = entry[1]
            graph[v].add(u)
        }

        fun getDependencies(
            u: Int,
            visited: BooleanArray,
            dependencies: MutableList<Int>
        ) {
            visited[u] = true
            for (v in graph[u]) {
                dependencies.add(v)
                if (!visited[v]) {
                    getDependencies(v, visited, dependencies)
                }
            }
        }

        val dependenciesMatrix = Array(numCourses) { BooleanArray(numCourses) { false } }
        for (u in 0..<numCourses) {
            val dependencies = mutableListOf<Int>()
            getDependencies(u, BooleanArray(numCourses) { false }, dependencies)
            for (d in dependencies) {
                dependenciesMatrix[d][u] = true
            }
        }

        val ans = mutableListOf<Boolean>()
        for (query in queries) {
            val result = dependenciesMatrix[query[0]][query[1]]
            ans.add(result)
        }
        return ans
    }
    */

    fun checkIfPrerequisite(
        numCourses: Int,
        prerequisites: Array<IntArray>,
        queries: Array<IntArray>
    ): List<Boolean> {
        val graph = Array(numCourses) { BooleanArray(numCourses) { false } }
        for (entry in prerequisites) {
            val u = entry[0]
            val v = entry[1]
            graph[v][u] = true
        }

        for (k in 0..<numCourses) {
            for (i in 0..<numCourses) {
                for (j in 0..<numCourses) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true
                    }
                }
            }
        }

        val ans = mutableListOf<Boolean>()
        for (query in queries) {
            val result = graph[query[1]][query[0]]
            ans.add(result)
        }
        return ans
    }
}