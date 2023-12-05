package leetcode;

public class LeetCode91 {
    private String encodedString;
    private int[] cache;

    private boolean isCodeValid(int code) {
        return 1 <= code && code <= 26;
    }

    private int makeCode(int pos, int length) {
        var code = 0;
        for (int i = pos - length + 1; i <= pos; i++) {
            int digit  = this.encodedString.charAt(i) - '0';
            code = code * 10 + digit;
        }
        return code;
    }

    private boolean canTakeOne(int pos) {
        return isCodeValid(makeCode(pos, 1));
    }

    private boolean canTakeTwo(int pos) {
        if (pos == 0) {
            return false;
        }

        if (this.encodedString.charAt(pos - 1) == '0') {
            return false;
        }

        return isCodeValid(makeCode(pos, 2));
    }


    private int numDecodings(int i) {
        if (i < 0) {
            return 1;
        }

        if (this.cache[i] != -1) {
            return this.cache[i];
        }

        var ans = 0;
        if (canTakeOne(i)) {
            ans += numDecodings(i - 1);
        }

        if (canTakeTwo(i)) {
            ans += numDecodings(i - 2);
        }

        this.cache[i] = ans;

        return ans;
    }

    public int numDecodings(String s) {
        this.encodedString = s;
        this.cache = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            this.cache[i] = -1;
        }

        return numDecodings(s.length() - 1);
    }
}
