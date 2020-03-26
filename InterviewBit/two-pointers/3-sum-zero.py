def get_two_sums(numbers, target):
    i, j = 0, len(numbers) - 1
    two_sums = []
    while i < j:
        x, y = numbers[i], numbers[j]
        sum = x + y
        if sum == target:
            two_sums.append((x, y))
            while i < j and numbers[i] == x:
                i += 1
            while i < j and numbers[j] == y:
                j -= 1
        elif sum > target:
            j -= 1
        else:
            i += 1
    return two_sums

class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def threeSum(self, numbers):
        numbers = sorted(numbers)
        ans = []
        i = 0
        while i < len(numbers) - 2:
            x = numbers[i]
            two_sums = get_two_sums(numbers[i+1:], -x)
            for y, z in two_sums:
                ans.append((x, y, z))

            while i < len(numbers) - 3 and numbers[i + 1] == x:
                i += 1
            i += 1
        return ans



print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
print(Solution().threeSum([1, -1, -1, 0]))