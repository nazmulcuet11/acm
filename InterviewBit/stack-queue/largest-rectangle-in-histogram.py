# O(n^3)
def get_max_area_brute_force(histogram):
    x, y, max_area = -1, -1, 0
    for i in range(len(histogram)):
        for j in range(i + 1, len(histogram)):
            min_height = 2**31-1
            for k in range(i, j+1):
                min_height = min(min_height, histogram[k])
            area = (j - i + 1) * min_height
            if area > max_area:
                x, y = i, j
                max_area = area
    # print(x, y, max_area)
    return max_area

# O(n^2)
def get_max_area_2(histogram):
    max_area = 0
    for i, bar in enumerate(histogram):
        j = i
        while j >= 0 and histogram[j] >= histogram[i]:
            j -= 1
        k = i
        while k < len(histogram) and histogram[k] >= histogram[i]:
            k += 1
        
        area = (k - j - 1) * bar
        max_area = max(area, max_area)

    return max_area


# O(n)
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

print(get_max_area([2, 1, 2, 3, 4, 1]))
print(get_max_area([90, 58, 69, 70, 82, 100, 13, 57, 47, 18]))
print(get_max_area_brute_force([90, 58, 69, 70, 82, 100, 13, 57, 47, 18]))
print(get_max_area_2([90, 58, 69, 70, 82, 100, 13, 57, 47, 18]))