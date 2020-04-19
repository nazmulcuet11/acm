class Solution:
    # @param A : tuple of strings
    # @return a list of list of integers
    def anagrams(self, arr):
        seen = {}
        for i in range(len(arr)):
            s = ''.join(sorted(arr[i]))
            if s in seen:
                seen[s].append(i + 1)
            else:
                seen[s] = [i + 1]
        
        return list(seen.values())

print(Solution().anagrams(["cat", "dog", "god", "tca"]))