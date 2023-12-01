package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    private int n;
    private StringBuilder current;
    private List<String> ans;

    private void generateParenthesis(int openingCount, int closingCount) {
        if (openingCount == n && closingCount == n) {
            ans.add(current.toString());
            return;
        }

        if (openingCount < n) {
            this.current.append("(");
            generateParenthesis(openingCount + 1, closingCount);
            this.current.setLength(this.current.length() - 1);
        }

        if (closingCount < openingCount) {
            this.current.append(")");
            generateParenthesis(openingCount, closingCount + 1);
            this.current.setLength(this.current.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.current = new StringBuilder();
        this.ans = new ArrayList<>();
        generateParenthesis(0, 0);
        return this.ans;
    }
}
