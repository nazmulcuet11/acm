def maxArea(histogram):
    histogram.append(0)
    maxArea, stack = 0, [] 
    for index, value in enumerate(histogram):
        if len(stack) > 0 and value < histogram[stack[-1]]:
            while len(stack) > 0 and value < histogram[stack[-1]]:
                lastIndex = stack.pop()
                maxArea = max(maxArea, histogram[lastIndex] * (index - lastIndex))
        stack.append(index)

    return maxArea

print(maxArea([2, 1, 2, 3, 1]))