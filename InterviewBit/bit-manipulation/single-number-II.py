# class Solution:
#     # @param A : tuple of integers
#     # @return an integer
#     def singleNumber(self, A):
#         bit_counts = [0] * 32
#         for number in A:
#             i = 0
#             while number > 0:
#                 bit_counts[i] += number & 1
#                 number >>= 1
#                 i += 1
#         ans = 0
#         for i in range(32):
#             if bit_counts[i] % 3 > 0:
#                 ans |= 1 << i

#         return ans

class Solution:
    # @param A : tuple of integers
    # @return an integer
    def singleNumber(self, A):
        ans = 0
        for i in range(32):
            count = 0
            for number in A:
                if number & (1 << i) > 0:
                    count += 1
            if (count % 3) == 1:
                ans |= 1 << i

        # Over flows
        if ans & (1 << 31) > 0:
            for i in range(32):
                ans ^= 1 << i
            return -(ans + 1)
        
        return ans

# print(Solution().singleNumber([1, 2, 4, 3, 3, 2, 2, 3, 1, 1]))
# print(Solution().singleNumber([0, 0, 0, 1]))
ans = Solution().singleNumber([-2,-2,1,1,-3,1,-3,-3,-4,-2])
print(ans)
print("{0:b}".format(ans))
print("{0:b}".format(-4))


def print_bits(number, bit_count):
    for i in range(bit_count-1, -1, -1):
        bit = 1 if number & (1 << i) > 0 else 0
        print(bit, end = '')
    print()

print_bits(-2, 32)
print_bits(21, 32)
print_bits(~21, 32)
print_bits(-21, 32)
print_bits(~-21, 32)