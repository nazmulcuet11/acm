class Solution:
    def find_lps(self, pattern):
        n = len(pattern)
        lps = [0] * n
        i, j = 0, 1
        while j < n:
            if pattern[i] == pattern[j]:
                lps[j] = i + 1
                i += 1
                j += 1
            elif i > 0:
                i = lps[i - 1]
            else:
                lps[j] = 0
                j += 1
        return lps

    def kmp(self, text, pattern):
        lps = self.find_lps(pattern)
        m = len(text)
        n = len(pattern)
        i, j = 0, 0
        while j < m:
            if i == n:
                break

            if text[j] == pattern[i]:
                i += 1
                j += 1
            elif i > 0:
                i = lps[i - 1]
            else:
                j += 1

        if i == n:
            return j - n

        return -1

    def strStr(self, haystack: str, needle: str) -> int:
        return self.kmp(haystack, needle)


print(Solution().strStr("fourscoreandsevenyearsagoourfathersbroughtforthuponthiscontinentanewnation",
      "ourfathersbroughtforthuponthiscontinentanewnation"))

print(Solution().strStr("abcde", "cde"))
