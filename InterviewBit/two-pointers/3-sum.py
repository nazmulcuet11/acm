def closest_two_sum(numbers, target):
    i, j = 0, len(numbers) - 1
    closest_sum = 0
    min_diff = 2**31-1
    while i < j:
        sum = numbers[i] + numbers[j]
        diff = abs(target - sum)
        if diff < min_diff:
            min_diff = diff
            closest_sum = sum
        if sum > target:
            j -= 1
        else:
            i += 1
    return closest_sum

class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def threeSumClosest(self, numbers, target):
        numbers = sorted(numbers)
        closest_sum = 0
        min_diff = 2**31-1
        for i in range(len(numbers)-2):
            sum = numbers[i] + closest_two_sum(numbers[i+1:], target - numbers[i])
            diff = abs(target - sum)
            if diff < min_diff:
                min_diff = diff
                closest_sum = sum
        return closest_sum


print(Solution().threeSumClosest([-1, 2, 1, -4], 1))
print(Solution().threeSumClosest([7, 2, -5, 10, -3, 4, 9, 1, -6, -10], 2))
print(Solution().threeSumClosest([-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33], 0))