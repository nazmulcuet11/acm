class Solution:
    # @param A : string
    # @param B : string
    # @return a strings
    def minWindow(self, s, t):
        # Generate t map
        seen = {c: 0 for c in t}
        for c in t:
            seen[c] -= 1
    
        ws, we = 0, 0
        ans_start, ans_end = -1, 2**31
        required_char = len(seen)
        while we < len(s):
            while required_char > 0 and we < len(s):
                c = s[we]
                if c in seen:
                    seen[c] += 1
                    if seen[c] == 0:
                        required_char -= 1
                we += 1

            while required_char == 0 and ws < len(s):
                window_size = we - ws
                if we - ws < ans_end - ans_start:
                    ans_start, ans_end = ws, we

                c = s[ws]
                if c in seen:
                    seen[c] -= 1
                    if seen[c] < 0:
                        required_char += 1
                ws += 1
        
        if ans_start == -1:
            return ''
        return s[ans_start: ans_end]

print(Solution().minWindow("AAAAAA", "AA"))
print(Solution().minWindow("w", "o"))
print(Solution().minWindow("ADOBECODEBANC", "ABC"))
        
