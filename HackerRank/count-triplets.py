#!/usr/local/bin/python3
import sys
from collections import Counter

def count_triplet(arr, r):
    counter_one = Counter()
    counter_two = Counter()

    cnt = 0
    for val in arr:
        cnt += counter_two[val]
        counter_two[val*r] += counter_one[val]
        counter_one[val*r] += 1

    return cnt
# end of count_triplet

if __name__ == "__main__":
    # sys.stdin = open('input.txt', 'r')
    n, r = input().split()
    arr = list(map(int, input().split()))
    print(count_triplet(arr, int(r)))
