package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode54 {
    public List<Integer> extractRow(int row, int fromCol, int toCol, int [][] matrix) {
        var ans = new ArrayList<Integer>();
        for (int col = fromCol; col <= toCol; col++) {
            ans.add(matrix[row][col]);
        }
        return ans;
    }

    public List<Integer> extractCol(int col, int fromRow, int toRow, int [][] matrix) {
        var ans = new ArrayList<Integer>();
        for (int row = fromRow; row <= toRow; row++) {
            ans.add(matrix[row][col]);
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0, maxRow = matrix.length - 1, minCol = 0, maxCol = matrix[0].length - 1;
        var ans = new ArrayList<Integer>();
        while (minRow <= maxRow && minCol <= maxCol) {
            // top row from left to right
            var topRow = extractRow(minRow, minCol, maxCol, matrix);
            ans.addAll(topRow);

            // right column from top to bottom
            var rightCol = extractCol(maxCol, minRow + 1, maxRow, matrix);
            ans.addAll(rightCol);

            // bottom row from right to left
            if (maxRow != minRow) {
                var bottomRow = extractRow(maxRow, minCol, maxCol - 1, matrix);
                Collections.reverse(bottomRow);
                ans.addAll(bottomRow);
            }

            // left column from bottom to top
            if (minCol != maxCol) {
                var leftCol = extractCol(minCol, minRow + 1, maxRow - 1, matrix);
                Collections.reverse(leftCol);
                ans.addAll(leftCol);
            }

            // update minRow, maxRow, minCol, maxCol
            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }

        return ans;
    }
}
