def is_set_bit(n, i):
    return True if (n & 1 << i) > 0 else False

def toggle_bit(n, i):
    n ^= (1 << i)
    return n

def set_bit(n, i):
    if not is_set_bit(n, i):
        n = toggle_bit(n, i)
    return n

def reset_bit(n, i):
    if is_set_bit(n, i):
        n = toggle_bit(n, i)
    return n

def reverse_bits(n):
    temp = n
    i = 0
    while temp > 0:
        n = toggle_bit(n, i)
        temp >>= 1
        i += 1
    return n


class Solution:
    # @param A : unsigned integer
    # @return an unsigned integer
    def reverse(self, A):
        ans = 0
        i = 0
        while A > 0:
            if is_set_bit(A, 0):
                ans = set_bit(ans, 31-i)
            i += 1
            A >>= 1
        return ans


print(Solution().reverse(0))
x = Solution().reverse(3)
y = "{0:b}".format(x)
print(y)
print(x)