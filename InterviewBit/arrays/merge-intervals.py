# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

from functools import cmp_to_key

class Solution:
    # @param intervals, a list of Intervals
    # @param new_interval, a Interval
    # @return a list of Interval
    def is_overlapping(self, a, b):
        if (b.start <= a.start and a.start <= b.end) or (b.start <= a.end and a.end <= b.end):
            return True
        return False

    def comp(self, a, b):
        if a.start < b.start or (a.start == b.start and  a.end < b.end):
            return -1
        elif a.start > b.start or (a.start == b.start and  a.end > b.end):
            return 1
        else:
            return 0

    def insert(self, intervals, new_interval):
        if new_interval.start > new_interval.end:
            new_interval = Interval(new_interval.end, new_interval.start)
        
        if len(intervals) == 0:
            return [new_interval]

        for interval in intervals:
            if interval.start > interval.end:
                interval = Interval(interval.end, interval.start)

            if self.is_overlapping(interval, new_interval):
                new_interval = Interval(min(new_interval.start, interval.start), max(new_interval.end, interval.end))

        ans = []
        for interval in intervals:
            if not self.is_overlapping(interval, new_interval):
                ans.append(interval)
        ans.append(new_interval)

        return sorted(ans, key=cmp_to_key(self.comp))


print(Solution().insert([(1, 2), (3, 6)], (10, 8)))