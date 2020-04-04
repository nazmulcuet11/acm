def get_max_area(histogram):
    histogram = histogram + [0]
    stack = []
    max_area = 0
    for i, bar in enumerate(histogram):
        while len(stack) > 0 and histogram[stack[-1]] > bar:
            t = stack.pop()
            # histogram at index will span from stack[-1] (excluding) in backword 
            # to i (excluding) in forward
            back_index = stack[-1] + 1 if len(stack) > 0 else 0
            area = (i - back_index) * histogram[t]
            max_area = max(area, max_area)
        stack.append(i)
    return max_area

print(get_max_area([6, 2, 5, 4, 5, 1, 6]))
print(get_max_area([90, 58, 69, 70, 82, 100, 13, 57, 47, 18]))