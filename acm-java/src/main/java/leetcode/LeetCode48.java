package leetcode;

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int s = 0, e = n - 1;
        for (int layer = 0; layer <= n / 2; layer++) {
            for (int i = 0; i < e - s; i++) {
                int t = matrix[s][s + i];
                matrix[s][s + i] = matrix[e - i][s];
                matrix[e - i][s] = matrix[e][e - i];
                matrix[e][e - i] = matrix[s + i][e];
                matrix[s + i][e] = t;
            }
            s++;
            e--;
        }
    }
}
