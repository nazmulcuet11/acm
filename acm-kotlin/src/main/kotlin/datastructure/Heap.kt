package datastructure

class Heap<Value: Comparable<Value>> {
    private val values = mutableListOf<Value>()
    private val indices = mutableMapOf<Value, Int>()

    fun add(value: Value) {
        values.add(value)
        indices[value] = values.size - 1
        float(values.size - 1)
    }

    fun remove(value: Value) {
        val index = indices[value] ?: return
        val lastIndex = values.size - 1
        swapValue(index, lastIndex)
        values.removeLast()
        indices.remove(value)
        if (index != lastIndex) {
            dive(index)
            float(index)
        }
    }

    fun top() = values.firstOrNull()

    fun poll(): Value? {
        val t = top() ?: return null
        remove(t)
        return t
    }

    fun isEmpty() = values.isEmpty()

    fun isNotEmpty() = values.isNotEmpty()

    override fun toString() = values.toString()

    private fun float(index: Int) {
        if (index == 0) {
            return
        }

        val parentIndex = (index - 1) / 2
        if (values[index] < values[parentIndex]) {
            swapValue(index, parentIndex)
            float(parentIndex)
        }
    }

    private fun dive(index: Int) {
        val leftIndex = index * 2 + 1
        val rightIndex = index * 2 + 2

        var minIndex = index
        if (leftIndex < values.size && values[leftIndex] < values[minIndex]) {
            minIndex = leftIndex
        }
        if (rightIndex < values.size && values[rightIndex] < values[minIndex]) {
            minIndex = rightIndex
        }

        if (index != minIndex) {
            swapValue(index, minIndex)
            dive(minIndex)
        }
    }

    private fun swapValue(index1: Int, index2: Int) {
        val value1 = values[index1]
        val value2 = values[index2]
        values[index1] = value2
        values[index2] = value1
        indices[value1] = index2
        indices[value2] = index1
    }
}