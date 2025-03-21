package leetcode

class LeetCode2115 {
    fun findAllRecipes(
        recipes: Array<String>,
        ingredients: List<List<String>>,
        supplies: Array<String>
    ): List<String> {
        val indegree = mutableMapOf<String, Int>()
        val graph = mutableMapOf<String, MutableSet<String>>()

        for ((recipe, ingredient) in recipes.zip(ingredients)) {
            for (item in ingredient) {
                graph[item]?.add(recipe) ?: run {
                    graph[item] = mutableSetOf(recipe)
                }
            }
            indegree[recipe] = ingredient.count()
        }

        val queue = ArrayDeque<String>()
        for (supply in supplies) {
            queue.add(supply)
        }

        while (queue.isNotEmpty()) {
            val top = queue.removeFirst()
            graph[top]?.let {
                for (recipe in it) {
                    indegree[recipe] = indegree.getOrDefault(recipe, 0) - 1
                    if (indegree[recipe] == 0) {
                        queue.add(recipe)
                    }
                }
            }
        }

        val ans = mutableListOf<String>()
        for (recipe in recipes) {
            indegree[recipe]?.let {
                if (it <= 0) {
                    ans.add(recipe)
                }
            }
        }
        return ans
    }
}