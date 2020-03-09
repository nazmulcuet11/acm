def longest_palindromic_substring(s, mid, mid_included_in_left):
    i, j, cnt = mid, mid + 1, 0
    if not mid_included_in_left:
        i = mid - 1
        cnt = 1

    while i >= 0 and j < len(s) and s[i] == s[j]:
        i -= 1
        j += 1
        cnt += 2

    return cnt
    
class Solution:
    # @param A : string
    # @return a strings
    def longestPalindrome(self, A):
        mx, mid, mid_included_in_left = 0, -1, False
        for i in range(len(A)):
            ret = longest_palindromic_substring(A, i, True)
            if ret > mx:
                mx = ret
                mid = i
                mid_included_in_left = True

            ret = longest_palindromic_substring(A, i, False)
            if ret > mx:
                mx = ret
                mid = i
                mid_included_in_left = False

        half_len = mx // 2
        start_index = mid - half_len
        end_index = mid + half_len
        if mid_included_in_left:
            start_index += 1

        return A[start_index : end_index+1]


print(Solution().longestPalindrome("aaaabaaa"))