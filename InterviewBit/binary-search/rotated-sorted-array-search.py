def rotatedSearch(A, x):
    l, h = 0, len(A)-1
    while l < h:
        m = (l + h) // 2
        if A[m] == x:
            return m
        # Left half sorted
        if A[l] <= A[m]:
            # x <= A[l] condition is Critical, because x might be less than A[l]
            #  and hence reside in the right half because of rotation
            if A[l] <= x and x < A[m]:
                h = m - 1
            else:
                l = m + 1
        # Atleasr one half of the array will be sorted
        # If left half is not sorted then right half 
        # must be sorted
        else:
            if A[m] < x and x <= A[h]:
                l = m + 1
            else:
                h = m - 1

    return l if A[l] == x else -1

class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return an integer
    def search(self, A, B):
        return rotatedSearch(A, B)

print(Solution().search([4, 5, 6, 7, 0, 1, 2, 3], 4))
print(Solution().search([5, 17, 100, 3], 6))

