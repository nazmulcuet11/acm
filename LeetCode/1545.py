class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        if n == 1:
            return "0"
        full_size = pow(2, n) - 1
        middle_position = full_size // 2
        if k - 1 == middle_position:  # K is in the middle, 
            return "1"
        if k > middle_position:
            new_k = full_size - k + 1
            t = self.findKthBit(n - 1, new_k)
            return "1" if t == "0" else "0"
        else:
            return self.findKthBit(n - 1, k)


# S1 = "0", lenght = 2^1 - 1
# S2 = "011" 2^2 - 1
# S3 = "0111001" 2^3 - 1
# S4 = "011100110110001" 2^4 - 1
