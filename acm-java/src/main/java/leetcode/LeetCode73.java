package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        var rowsToSetZero = new ArrayList<Integer>();
        var colsToSetZero = new ArrayList<Integer>();

        // scan
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rowsToSetZero.add(row);
                    colsToSetZero.add(col);
                }
            }
        }

        for (Integer row : rowsToSetZero) {
            Arrays.fill(matrix[row], 0);
        }

        for (Integer col : colsToSetZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }
}
