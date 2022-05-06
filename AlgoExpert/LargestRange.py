# Time: O(N * log(N))
# Space: O(1)
# def largestRange(array):
#     array.sort()
#     currentRangeLength = 1
#     start, end = array[0], array[0]
#     maxRangeLength = 1
#     maxStart, maxEnd = array[0], array[0]

#     for i in range(1, len(array)):
#         if array[i] == array[i - 1] + 1:
#             currentRangeLength += 1
#             end = array[i]
# 		elif array[i] != array[i - 1]:
#             currentRangeLength = 1
#             start = array[i]
#             end = array[i]

#         if currentRangeLength > maxRangeLength:
#             maxRangeLength = currentRangeLength
#             maxStart = start
#             maxEnd = end

#     return [maxStart, maxEnd]

# Time: O(N)
# Space: O(1)
def largestRange(array):
    nums = {v: True for v in array}
    maxLen = 0
    s, e = -1, -1
    
    for v in array:
        if v not in nums:
            continue

        del nums[v]
        currLen = 1

        # expand left
        l = v - 1
        while l in nums:
            del nums[l]
            currLen += 1
            l -= 1

        # expand right
        r = v + 1
        while r in nums:
            del nums[r]
            currLen += 1
            r += 1

        if currLen > maxLen:
            maxLen = currLen
            s = l + 1
            e = r - 1

    return [s, e]

array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
print(largestRange(array))
# [0 - 7]

array = [19, -1, 18, 17, 2, 10, 3, 12, 5, 16,
         4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14]
print(largestRange(array))
# [10 - 19]

array = [1, 1, 1, 3, 4]
print(largestRange(array))
# [3, 4]
