# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
    
    def __repr__(self):
        return "({0}, {1})".format(self.start, self.end)

from functools import cmp_to_key

class Solution:
    # @param intervals, a list of Intervals
    # @param new_interval, a Interval
    # @return a list of Interval
    def is_overlapping(self, a, b):
        if (b.start <= a.start and a.start <= b.end) or (b.start <= a.end and a.end <= b.end) or (a.start <= b.start and b.start <= a.end) or (a.start <= b.end and b.end <= a.end):
            return True
        return False

    def comp(self, a, b):
        if a.start < b.start or (a.start == b.start and  a.end < b.end):
            return -1
        elif a.start > b.start or (a.start == b.start and  a.end > b.end):
            return 1
        else:
            return 0

    def merge(self, intervals):
        print(intervals)
        for interval in intervals:
            if interval.start > interval.end:
                interval = Interval(interval.end, interval.start)

        intervals = sorted(intervals, key=cmp_to_key(self.comp))
        print(intervals)
        ans = []
        ans.append(intervals[0])
        for i in range(1, len(intervals)):
            print(i)
            if self.is_overlapping(ans[-1], intervals[i]):
                ans[-1] = Interval(min(intervals[i].start, ans[-1].start), max(intervals[i].end, ans[-1].end))
            else:
                ans.append(intervals[i])
        
        return ans


intervals = list(map(lambda x: Interval(x[0], x[1]), [(1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)]))
print(Solution().merge(intervals))