class Solution:
    # @param A : string
    # @param B : tuple of strings
    # @return a list of integers
    def findSubstring(self, a, b):
        if len(b) == 0:
            return []

        seen = {}
        for s in b:
            seen[s] = seen.get(s, 0) + 1
    
        i, l = 0, len(b[0])
        ans = []
        while i + l <= len(a):
            seen_a = {}
            j = i
            required = len(seen)
            while required and j + l <= len(a):
                sub = a[j: j+l]
                seen_a[sub] = seen_a.get(sub, 0) + 1
                if sub not in seen or seen_a[sub] > seen[sub]:
                    break
                else:
                    if seen_a[sub] == seen[sub]:
                        required -= 1
                    j += l
                    
            if required == 0:
                ans.append(i)
            i += 1
        return ans

S = "barfoothefoobarman"
L = ["foo", "bar"]
print(Solution().findSubstring(S, L))
