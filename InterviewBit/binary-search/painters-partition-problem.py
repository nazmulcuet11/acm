def isPossible(boards, painter_count, length):
    for b in boards:
        if b > length:
            return False
    
    current_length = 0
    for i in range(len(boards)):
        if current_length + boards[i] > length:
            painter_count -= 1
            if painter_count <= 0:
                return False
            current_length = boards[i]
        else:
            current_length += boards[i]
    return True

class Solution:
    # @param A : integer
    # @param B : integer
    # @param C : list of integers
    # @return an integer
    def paint(self, A, B, C):
        l, h = 0, 0 
        for i in range(len(C)):
            h += C[i]

        while l < h:
            m = (l + h) // 2
            if isPossible(C, A, m):
                h = m
            else:
                l = m + 1
        
        return (l * B) % 10000003

print(Solution().paint(2, 5, [1, 10]))
print(Solution().paint(10, 1, [1, 8, 11, 3]))
