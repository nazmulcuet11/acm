package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode7 {
    ArrayList<Integer> getDigits(Integer n) {
        var digits = new ArrayList<Integer>();
        while (n != 0) {
            digits.add(Math.abs(n % 10));
            n /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    Integer getInteger(ArrayList<Integer> digits) {
        int ans = 0;
        for (var digit: digits) {
            ans = ans * 10 + digit;
        }
        return ans;
    }

    void makeLengthsEqual(ArrayList<Integer> lhs, ArrayList<Integer> rhs) {
        Collections.reverse(lhs);
        Collections.reverse(rhs);

        while (lhs.size() < rhs.size())
            lhs.add(0);

        while (rhs.size() < lhs.size())
            rhs.add(0);

        Collections.reverse(lhs);
        Collections.reverse(rhs);
    }

    boolean isGreaterThan(ArrayList<Integer> lhs, ArrayList<Integer> rhs) {
        ArrayList<Integer> _lhs = new ArrayList<>(lhs);
        ArrayList<Integer> _rhs = new ArrayList<>(rhs);
        makeLengthsEqual(_lhs, _rhs);
        for (int i = 0; i < _lhs.size(); i++) {
            if (_lhs.get(i) < _rhs.get(i)) {
                return false;
            } else if (_lhs.get(i) > _rhs.get(i)) {
                return true;
            }
        }
        return false;
    }

    public int reverse(int x) {
        var digitsOfX = getDigits(x);
        Collections.reverse(digitsOfX);
        var numberToCompareWith = x < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        if (isGreaterThan(digitsOfX, getDigits(numberToCompareWith))) {
            return 0;
        }
        var multiplier = x < 0 ? -1 : 1;
        return multiplier * getInteger(digitsOfX);
    }
}
