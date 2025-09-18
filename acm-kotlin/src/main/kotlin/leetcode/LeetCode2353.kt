package leetcode

import java.util.TreeSet

class LeetCode2353 {
    data class FoodData(val name: String, val rating: Int, val cuisine: String): Comparable<FoodData> {
        override fun compareTo(other: FoodData): Int {
            if (rating == other.rating) {
                return name.compareTo(other.name)
            }
            return other.rating.compareTo(rating)
        }
    }

    class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
        private val foodDataMap = mutableMapOf<String, FoodData>()
        private val cuisineToFoods = mutableMapOf<String, TreeSet<FoodData>>()

        init {
            for (i in foods.indices) {
                val foodData = FoodData(
                    name = foods[i],
                    rating = ratings[i],
                    cuisine = cuisines[i]
                )
                add(foodData)
            }
        }

        fun changeRating(food: String, newRating: Int) {
            val oldFoodData = foodDataMap[food] ?: return
            remove(oldFoodData)
            val newFoodData = FoodData(food, newRating, oldFoodData.cuisine)
            add(newFoodData)
        }

        fun highestRated(cuisine: String): String {
            val foodDataSet = cuisineToFoods[cuisine] ?: return ""
            return foodDataSet.first().name
        }

        private fun add(foodData: FoodData) {
            foodDataMap[foodData.name] = foodData
            cuisineToFoods.getOrPut(foodData.cuisine) { TreeSet() }.add(foodData)
        }

        private fun remove(foodData: FoodData) {
            foodDataMap.remove(foodData.name)
            cuisineToFoods[foodData.cuisine]?.remove(foodData)
        }
    }
}