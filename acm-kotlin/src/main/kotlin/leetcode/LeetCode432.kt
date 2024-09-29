package leetcode

class LeetCode432 {
    class AllOne() {
        private abstract class Heap {
            data class Info(
                val key: String,
                val count: Int
            )

            private fun <T> MutableList<T>.swap(i: Int, j: Int) {
                val t = this[i]
                this[i] = this[j]
                this[j] = t
            }

            protected val keyToIndex = mutableMapOf<String, Int>()
            protected val data = mutableListOf<Info>()

            abstract fun shouldSwim(currentIndex: Int, parentIndex: Int): Boolean

            abstract fun diveNextIndex(currentIndex: Int, leftChildIndex: Int, rightChildIndex: Int): Int

            fun insert(info: Info) {
                data.add(info)
                keyToIndex[info.key] = data.size - 1

                var currentIndex = data.size - 1
                while (currentIndex > 0) {
                    val parentIndex = (currentIndex - 1) / 2

                    if (!shouldSwim(currentIndex, parentIndex)) {
                        break
                    }

                    val parent = data[parentIndex]
                    val current = data[currentIndex]

                    // swap
                    data.swap(currentIndex, parentIndex)

                    // update dictionary
                    keyToIndex[parent.key] = currentIndex
                    keyToIndex[current.key] = parentIndex

                    currentIndex = parentIndex
                }
            }

            fun remove(key: String) {
                val index = keyToIndex[key] ?: return

                data.swap(index, data.size - 1)
                keyToIndex[data[index].key] = index
                data.removeLast()
                keyToIndex.remove(key)

                var currentIndex = index
                while (currentIndex < data.size) {
                    val leftChildIndex = currentIndex * 2 + 1
                    val rightChildIndex = currentIndex * 2 + 2

                    val nextIndex = diveNextIndex(currentIndex, leftChildIndex, rightChildIndex)
                    if (nextIndex == currentIndex) {
                        break
                    }

                    val current = data[currentIndex]
                    val next = data[nextIndex]

                    // swap
                    data.swap(currentIndex, nextIndex)

                    // update dictionary
                    keyToIndex[next.key] = currentIndex
                    keyToIndex[current.key] = nextIndex

                    currentIndex = nextIndex
                }
            }

            fun count(key: String): Int? {
                keyToIndex[key]?.let {
                    return data[it].count
                }
                return null
            }

            fun top(): String {
                if (data.isEmpty()) {
                    return ""
                }
                return data[0].key
            }
        }

        private class MinHeap: Heap() {
            override fun shouldSwim(currentIndex: Int, parentIndex: Int): Boolean {
                return data[parentIndex].count > data[currentIndex].count
            }

            override fun diveNextIndex(currentIndex: Int, leftChildIndex: Int, rightChildIndex: Int): Int {
                var minIndex = currentIndex
                if (leftChildIndex < data.size && data[leftChildIndex].count < data[minIndex].count) {
                    minIndex = leftChildIndex
                }

                if (rightChildIndex < data.size && data[rightChildIndex].count < data[minIndex].count) {
                    minIndex = rightChildIndex
                }
                return minIndex
            }
        }

        private class MaxHeap: Heap() {
            override fun shouldSwim(currentIndex: Int, parentIndex: Int): Boolean {
                return data[parentIndex].count < data[currentIndex].count
            }

            override fun diveNextIndex(currentIndex: Int, leftChildIndex: Int, rightChildIndex: Int): Int {
                var maxIndex = currentIndex
                if (leftChildIndex < data.size && data[leftChildIndex].count > data[maxIndex].count) {
                    maxIndex = leftChildIndex
                }

                if (rightChildIndex < data.size && data[rightChildIndex].count > data[maxIndex].count) {
                    maxIndex = rightChildIndex
                }
                return maxIndex
            }
        }

        private val minHeap = MinHeap()
        private val maxHeap = MaxHeap()

        private enum class Operation {
            INCREMENT,
            DECREMENT,
        }

        private fun update(key: String, operation: Operation) {
            val count = minHeap.count(key) ?: 0

            minHeap.remove(key)
            maxHeap.remove(key)

            when (operation) {
                Operation.INCREMENT -> {
                    minHeap.insert(Heap.Info(key, count + 1))
                    maxHeap.insert(Heap.Info(key, count + 1))
                }
                Operation.DECREMENT -> {
                    if (count != 1) {
                        minHeap.insert(Heap.Info(key, count - 1))
                        maxHeap.insert(Heap.Info(key, count - 1))
                    }
                }
            }

        }

        fun inc(key: String) {
            update(key, Operation.INCREMENT)
        }

        fun dec(key: String) {
            update(key, Operation.DECREMENT)
        }

        fun getMaxKey(): String {
            return maxHeap.top()
        }

        fun getMinKey(): String {
            return minHeap.top()
        }
    }
}