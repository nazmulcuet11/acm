package leetcode

class LeetCode1352 {
    class ProductOfNumbers() {
        private var products = mutableListOf<Int>()

        fun add(num: Int) {
            if (num == 0) {
                products = mutableListOf()
            } else {
                if (products.isEmpty()) {
                    products.add(num)
                } else {
                    products.add(num * products.last())
                }
            }
        }

        fun getProduct(k: Int): Int {
            return if (k > products.size) {
                0
            } else if (k == products.size) {
                products.last()
            } else {
                products.last() / products[products.size - k - 1]
            }
        }
    }
}