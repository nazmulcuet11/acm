class Solution:
    def hasOverlap(self, a, b):
        if a[0] <= b[0] and b[0] <= a[1] + 1:
            return True
        if a[0] <= b[1] + 1 and b[1] <= a[1]:
            return True
        if b[0] <= a[0] and a[0] <= b[1] + 1:
            return True
        if b[0] <= a[1] + 1 and a[1] <= b[1]:
            return True
        return False

    def merge(self, a, b):
        return (min(a[0], b[0]), max(a[1], b[1]))

    def mergeIntervals(self, intervals):
        merged = []
        for interval in intervals:
            if len(merged) == 0 or not self.hasOverlap(merged[-1], interval):
                merged.append(interval)
            else:
                merged[-1] = self.merge(merged[-1], interval)

            if len(merged) > 1 and self.hasOverlap(merged[-1], merged[-2]):
                merged[-2] = self.merge(merged[-1], merged[-2])
                merged.pop()

        return merged

    def length(self, a):
        return abs(a[0] - a[1]) + 1

    def longestValidParentheses(self, s: str) -> int:
        intervals = []
        stk = []
        for i, ch in enumerate(s):
            if ch == '(':
                stk.append(i)
            elif len(stk) > 0:
                intervals.append((stk.pop(), i))

        intervals = self.mergeIntervals(intervals)
        mx = 0
        for interval in intervals:
            mx = max(mx, self.length(interval))
        return mx


# "()(())"
