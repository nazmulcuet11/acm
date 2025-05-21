class LeetCode73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var firstRowHasZero = false
        for (i in matrix[0].indices) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true
                break
            }
        }

        var firstColHasZero = false
        for (i in matrix.indices) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true
                break
            }
        }

        for (i in 1..<matrix.size) {
            for (j in 1..<matrix[i].size) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }

        for (i in 1..<matrix.size) {
            if (matrix[i][0] == 0) {
                for (j in 1..<matrix[i].size) {
                    matrix[i][j] = 0
                }
            }
        }

        for (i in 1..<matrix[0].size) {
            if (matrix[0][i] == 0) {
                for (j in 1..<matrix.size) {
                    matrix[j][i] = 0
                }
            }
        }

        if (firstRowHasZero) {
            for (i in matrix[0].indices) { 
                matrix[0][i] = 0
            }
        }

        if (firstColHasZero) {
            for (i in matrix.indices) { 
                matrix[i][0] = 0
            }
        }
    }
}
