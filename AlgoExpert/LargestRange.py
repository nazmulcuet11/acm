def largestRange(array):
    array.sort()
    currentRangeLength = 1
    start, end = array[0], array[0]
    maxRangeLength = 1
    maxStart, maxEnd = array[0], array[0]

    for i in range(1, len(array)):
        if array[i] == array[i - 1] + 1:
            currentRangeLength += 1
            end = array[i]
        elif array[i] != array[i - 1]:
            currentRangeLength = 1
            start = array[i]
            end = array[i]

        if currentRangeLength > maxRangeLength:
            maxRangeLength = currentRangeLength
            maxStart = start
            maxEnd = end

    return [maxStart, maxEnd]


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
