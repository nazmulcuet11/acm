package leetcode;

public class LeetCode97 {
    private String s1;
    private String s2;
    private String s3;
    private int[][][] cache;

    private int isInterleave(int i, int j, int k) {
        if (i == -1 && j == -1 && k == -1) {
            return 1;
        }

        if (cache[i + 1][j + 1][k + 1] != -1) {
            return cache[i + 1][j + 1][k + 1];
        }

        var ans = 0;
        if (i >= 0 && k >= 0 && this.s1.charAt(i) == this.s3.charAt(k)) {
            ans |= isInterleave(i - 1, j, k - 1);
        }

        if (j >= 0 && k >= 0 && this.s2.charAt(j) == this.s3.charAt(k)) {
            ans |= isInterleave(i, j - 1, k - 1);
        }

        this.cache[i + 1][j + 1][k + 1] = ans;
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.cache = new int[101][101][201];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                for (int k = 0; k <= s3.length(); k++) {
                    this.cache[i][j][k] = -1;
                }
            }
        }

        return isInterleave(s1.length() - 1, s2.length() - 1, s3.length() - 1) == 1;
    }
}
