class Solution:
    # @param A : string
    # @return an integer
    def romanToInt(self, A):
        INT_FOR_ROMAN = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000 }
        int_val = 0
        for i in range(len(A)):
            if i < len(A)-1 and INT_FOR_ROMAN[A[i]] < INT_FOR_ROMAN[A[i+1]]:
                int_val -= INT_FOR_ROMAN[A[i]]
            else:
                int_val += INT_FOR_ROMAN[A[i]]

        return int_val