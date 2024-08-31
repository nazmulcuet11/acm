package leetcode

class LeetCode149 {
    data class Vector(
        val x: Int,
        val y: Int,
    ) {
        constructor(a: Vector, b: Vector): this(b.x - a.x, b.y - a.y)

        infix fun cross(other: Vector) = this.x * other.y - this.y * other.x
    }

    fun maxPoints(points: Array<IntArray>): Int {
        val vectors = mutableListOf<Vector>()
        for (point in points) {
            vectors.add(
                Vector(point[0], point[1])
            )
        }

        var maxCount = 1
        for (i in vectors.indices) {
            for (j in i + 1..<vectors.size) {
                val a = Vector(vectors[i], vectors[j])
                var count = 2
                for (k in j + 1..<vectors.size) {
                    val b = Vector(vectors[i], vectors[k])
                    if (a cross b == 0) {
                        count++
                    }
                }
                maxCount = maxOf(count, maxCount)
            }
        }

        return maxCount
    }
}