package leetcode;

import java.util.*;

public class LeetCode402 {
    private Map<Integer, Queue<Integer>> digitToIndices;
    private int minAllowedIndex;
    private int maxAllowedIndex;

    private void initializeDigitToIndices(String num) {
        this.digitToIndices = new HashMap<>();

        for(int i = 0; i <= 9; i++) {
            this.digitToIndices.put(i, new ArrayDeque<>());
        }

        for(int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            this.digitToIndices.get(digit).add(i);
        }
    }

    private void initializeMinMaxAllowedIndices(int k) {
        this.minAllowedIndex = 0;
        this.maxAllowedIndex = k;
    }

    private void removeLeadingZeros(List<Integer> digits) {
        Collections.reverse(digits);
        while (!digits.isEmpty() && digits.get(digits.size() - 1) == 0) {
            digits.remove(digits.size() - 1);
        }
        Collections.reverse(digits);
    }

    private void prune() {
        for(int digit = 0; digit <= 9; digit++) {
            var queue = this.digitToIndices.get(digit);
            while (!queue.isEmpty() && queue.peek() < this.minAllowedIndex) {
                queue.remove();
            }
        }
    }

    private int peekNextDigit() {
        this.prune();

        for(int digit = 0; digit <= 9; digit++) {
            var queue = digitToIndices.get(digit);
            if (!queue.isEmpty() && queue.peek() <= maxAllowedIndex) {
                int digitIndex = queue.peek();
                this.minAllowedIndex = digitIndex + 1;
                this.maxAllowedIndex++;
                return digit;
            }
        }

        return 0;
    }

    private String convertDigitsToString(List<Integer> digits) {
        removeLeadingZeros(digits);

        StringBuilder builder = new StringBuilder(digits.size());
        for(Integer digit: digits) {
            builder.append(digit);
        }
        return builder.toString();
    }

    public String removeKdigits(String num, int k) {
        this.initializeDigitToIndices(num);
        this.initializeMinMaxAllowedIndices(k);


        var answerDigits = new ArrayList<Integer>();
        while (answerDigits.size() + k < num.length()) {
            int digit = peekNextDigit();
            answerDigits.add(digit);
        }

        var answer = this.convertDigitsToString(answerDigits);
        if (answer.isEmpty()) {
            return "0";
        }
        return answer;
    }
}
