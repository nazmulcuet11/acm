package leetcode

class LeetCode432 {
    class AllOne() {
        private class Heap(val type: HeapType) {
            data class Info(
                val key: String,
                val count: Int
            )

            enum class HeapType {
                MIN,
                MAX,
            }

            private fun <T> MutableList<T>.swap(i: Int, j: Int) {
                val t = this[i]
                this[i] = this[j]
                this[j] = t
            }

            private val keyToIndex = mutableMapOf<String, Int>()
            private val data = mutableListOf<Info>()

            fun insert(info: Info) {
                data.add(info)
                keyToIndex[info.key] = data.size - 1

                var currentIndex = data.size - 1
                while (currentIndex > 0) {
                    val parentIndex = (currentIndex - 1) / 2

                    if ((type == HeapType.MIN && data[parentIndex].count <= data[currentIndex].count) ||
                        (type == HeapType.MAX && data[parentIndex].count >= data[currentIndex].count)) {
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

                    var nextIndex = currentIndex
                    if (leftChildIndex < data.size &&
                        ((type == HeapType.MIN && data[leftChildIndex].count < data[nextIndex].count) ||
                            (type == HeapType.MAX  && data[leftChildIndex].count > data[nextIndex].count))) {
                        nextIndex = leftChildIndex
                    }

                    if (rightChildIndex < data.size &&
                        ((type == HeapType.MIN && data[rightChildIndex].count < data[nextIndex].count) ||
                            (type == HeapType.MIN && data[rightChildIndex].count > data[nextIndex].count))) {
                        nextIndex = rightChildIndex
                    }

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

        private val minHeap = Heap(Heap.HeapType.MIN)
        private val maxHeap = Heap(Heap.HeapType.MAX)

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