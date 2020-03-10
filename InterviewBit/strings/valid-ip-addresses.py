def is_valid(s):
    if len(s) == 0:
        return False
    if s[0] == '0' and len(s) > 1:
        return False
    if int(s) >= 256:
        return False
    return True

class Solution:
    # @param A : string
    # @return a list of strings
    def restoreIpAddresses(self, A):
        addresses = []
        for i in range(1, len(A)-2):
            for j in range(i+1, len(A)-1):
                for k in range(j+1, len(A)):
                    if is_valid(A[:i]) and is_valid(A[i:j]) and is_valid(A[j:k]) and is_valid(A[k:]):
                        address = A[:i] + '.' + A[i:j] + '.' + A[j:k] + '.' + A[k:]
                        addresses.append(address)

        return sorted(addresses)
        

print(Solution().restoreIpAddresses("25525511135"))
print(Solution().restoreIpAddresses("0100100"))