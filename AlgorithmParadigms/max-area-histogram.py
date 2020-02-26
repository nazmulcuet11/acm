def maxArea(histogram):
    histogram.append(0)
    maxArea, stack = 0, [] 
    for index, value in enumerate(histogram):
        while len(stack) > 0 and value < histogram[stack[-1]]:
            lastIndex = stack.pop()
            span = (index - stack[-1] - 1) if len(stack) > 0 else index
            maxArea = max(maxArea, histogram[lastIndex] * span)
        stack.append(index)

    return maxArea

print(maxArea([6, 2, 5, 4, 5, 1, 6]))