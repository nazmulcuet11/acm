def isPossible(books, student_count, max_page):
    for b in books:
        if b > max_page:
            return False
    
    current = 0
    last_student_start = 0
    for i in range(len(books)):
        if current + books[i] > max_page:
            student_count -= 1
            last_student_start = i
            if student_count <= 0:
                return False
            current = books[i]
        else:
            current += books[i]
    
    # if len(books) - last_student_start >= student_count:
    #     return True
    # return False

    return True

class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def books(self, A, B):
        if B > len(A):
            return -1

        l, h = 0, 0 
        for i in range(len(A)):
            h += A[i]

        while l < h:
            m = (l + h) // 2
            if isPossible(A, B, m):
                h = m
            else:
                l = m + 1
        
        return l

print(Solution().books([12, 34, 67, 90], 12))
print(Solution().books([5, 17, 100, 11], 4))
