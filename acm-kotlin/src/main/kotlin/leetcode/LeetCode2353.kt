package leetcode

class LeetCode2353 {
    data class Food(val name: String, val rating: Int) {
        operator fun compareTo(other: Food): Int {
            if (rating == other.rating) {
                return other.name.compareTo(name)
            }
            return rating.compareTo(other.rating)
        }
    }

    class Heap {
        private val foods = mutableListOf<Food>()
        private val foodIndex = mutableMapOf<String, Int>()

        fun add(food: Food) {
            foods.add(food)
            foodIndex[food.name] = foods.size - 1
            swim(foods.size - 1)
        }

//        fun remove(food: Food) {
//            val index = foodIndex[food.name] ?: return
//            swapFoods(index, foods.size - 1)
//            foods.removeLast()
//            foodIndex.remove(food.name)
//            dive(index)
//        }

        fun remove(name: String) {
            val index = foodIndex[name] ?: return
            swapFoods(index, foods.size - 1)
            foods.removeLast()
            foodIndex.remove(name)
            dive(index)
        }

        fun top(): Food  = foods.first()

        private fun swim(index: Int) {
            val parentIndex = (index - 1) / 2
            if (foods[index] > foods[parentIndex]) {
                swapFoods(index, parentIndex)
                swim(parentIndex)
            }
        }

        private fun dive(index: Int) {
            val leftIndex = index * 2 + 1
            val rightIndex = index * 2 + 2

            var maxIndex = index
            if (leftIndex < foods.size && foods[leftIndex] > foods[maxIndex]) {
                maxIndex = leftIndex
            }
            if (rightIndex < foods.size && foods[rightIndex] > foods[maxIndex]) {
                maxIndex = rightIndex
            }

            if (index != maxIndex) {
                swapFoods(index, maxIndex)
                dive(maxIndex)
            }
        }

        private fun swapFoods(index1: Int, index2: Int) {
            val food1 = foods[index1]
            val food2 = foods[index2]
            foods[index1] = food2
            foods[index2] = food1
            foodIndex[food1.name] = index2
            foodIndex[food2.name] = index1
        }
    }

    class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
        private val heaps = mutableMapOf<String, Heap>()
        private val foodCuisines = mutableMapOf<String, String>()

        init {
            for (i in foods.indices) {
                val food = Food(
                    name = foods[i],
                    rating = ratings[i]
                )
                if (heaps[cuisines[i]] == null) {
                    heaps[cuisines[i]] = Heap()
                }
                heaps[cuisines[i]]?.add(food)
                foodCuisines[foods[i]] = cuisines[i]
            }
        }

        fun changeRating(food: String, newRating: Int) {
            val cuisine = foodCuisines[food] ?: return
            val heap = heaps[cuisine] ?: return
            heap.remove(food)
            heap.add(Food(food, newRating))
        }

        fun highestRated(cuisine: String): String {
            val heap = heaps[cuisine] ?: return ""
            return heap.top().name
        }
    }
}