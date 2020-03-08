def build_suffix_table(pattern):
    suffix_table = [0]
    for i in range(1, len(pattern)):
        j = suffix_table[i-1]
        while j > 0 and pattern[j] != pattern[i]:
            j = suffix_table[j-1]
        if pattern[j] == pattern[i]:
            suffix_table.append(j + 1)
        else:
            suffix_table.append(0)

    # i, j = 1, 0
    # suffix_table = [0] 
    # while i < len(pattern): 
    #     if pattern[i] == pattern[j]: 
    #         suffix_table.append(j + 1)
    #         i += 1
    #         j += 1
    #     else: 
    #         if j != 0:
    #             j = suffix_table[j-1] 
    #         else: 
    #             suffix_table.append(0)
    #             i += 1
        
    min_len = len(pattern) - suffix_table[len(pattern)-1]
    if len(pattern) % min_len == 0:
        return min_len
    return len(pattern)

def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

class Solution:
    # @param A : list of strings
    # @return an integer
    def solve(self, A):
        required_times  = []
        for s in A:
            l  = build_suffix_table(s)
            total_rotated_char, time  = 1, 1 
            while  total_rotated_char % l != 0:
                time += 1
                total_rotated_char += time % len(s)
            required_times.append(time)

        MOD = 1000000007
        l = required_times[0]
        for i in range(1, len(required_times)):
            # for j in range(i+1, len(required_times)):
            #     required_times[j] //= gcd(required_times[i], required_times[j])

            l = (l * required_times[i]) // gcd(l, required_times[i])
            # l %= MOD
        
        return l % MOD

# print(Solution().solve(['a', 'ababa', 'aba']))
# print(Solution().solve(['aaaa', 'aaaaa', 'aaaa']))
A = [ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "babaaaabbaba", "baaaaababaabbaaaaabbbbbbbaabbaaaababbabaababaabaaabbbaaaaa", "abaabb", "aababbbbabbaaaabbaaaaaaaababbbabbbbaabbaabaabbaabaababbbababaababaabbababaaabaaaab", "babaaaaababbbbbabbbbabbaaabaaaababbabbaabbbabbaaaabbbabaaaabaaaababb", "bbbbbbaaaaaabbbbbbababaabaabbbbbaaabbabbaabbbbaaaaaababbabaaabbabbabbbabbaabbabbbbaabbbaaaaabbabaaab", "aabaaabaabbbbababbabbabaaaababbababbbabbbbaabbaaaaababbbbbababbbbaaababababab", "aaaababbbaabbbabaabb", "ababaaaabbabbbbaaabbababbbabbbabaaa", "aaabaabbbabaa", "baababbababbbbbabbabaabbabbbbbaaaabaaaababaa", "babaa", "abbabababbbbbbbbbbbaaaaaababbababaaabbbaaaabbbababbabaabbaabbbbaabbbaabbababababaabaaabbaaabbba", "ababbaabbaaabbbabaabababbbabaaabbbaababaaa", "abbaaaababbbbaaabaaaabaaaaabaababbabbaababbbabbbbbbbbbabbaabaaabbaaababbbaa", "bbabababaabbabbabbbabbaababbabaaabbbababab", "abbbaaabaab", "bbaaabbaaabbaabbabababa", "aabaabaaaaaaabaabbbaaababbbbbbababbaabababbaaaaabbabbbabbbaababbaabababbbbbbbbbaabaab", "babbaaabbabbaabaaabbb", "bbabaabba", "baabaaaaabbaaaaaabbbbaaaabababa", "babbaababaaba", "baabaabaabbababbaabbabbbbbabaaaabbbbbabbabbbbbabbbabaabbbbabbbbaaabbbbabababaaaababbaaabbabb", "abbbbaaaabaabbabbaababaabbababbbaaabbabbbbbaaabbabbaabbb", "bababaaaaabababbabbaabababbbaabbaabaabaabbabbbababbaaabababbababbbb", "abaaabbbabbbaabba", "bbbbaaaabbbababaabbbababaaaababbaaaaaabbbabbaababababbba", "bababaabaaaabbaabbababbaabbaabaabbaaaaaaaababbaaaaaabbaaabaabaaababbababbbbaabbabbabaabab", "aabbbabaaabababaabbbbaabbabaaabbbaaabbabbbbabaabbbbaabbbaaaaabbbabbbbb", "aabbbbbbabaabbbabbaababbababaabaaababbbbabbbaababaaaabbaaabaaabaaaabbbabababbab", "abaaaaababbabaabbbaaaaabbaaaabaaaaaaaababbaabbbaabbabbbabbaaaaaab", "bbbaabbabbbbbbaaaabbabbbbbbbaaabaababbaaaabbbaababbaaabbbbbbbbabbabababbaaabaabaaabaaaabbbbbabaabaaa", "bbaaabaaabaaabaabaaabbaabaabbabaabaabbababaaaaabaabbbbaba", "abaababaaabbabaabaabbbaaabbaabababbabaaabbbbabbbbbaaaaa", "abba", "abbbababbaaabbaaabbbabaabbababaaabbbbaaaaababbabbaabbabbbaaabaabbaaaaabaaaabbbaabbbabbbbbbbabb", "bbabbaaabaaaabbaaaabbbaaaababbbaabaaaaab", "abbaabaabbaaaaaaaabbaabbabbababaaaaaaabbabaabaabbbabbaabbaababbaabbaba", "bbbbaababbaaaaaaaaabbbabbbabaabababaababaababa", "baaabaabbbbbbaabbabbbabaaaaababaabaababbbaaaaaaaabbbbbabbabaaaaaaaabababaabaababaaabbaaaaaaaaabaa", "aababbbabbaaaaababbabaababbbbbbbbaaabbaaaaabbaabbbba", "ababababaaaaaabbbabbaaababaabb", "bababbaababaabbbabbaab", "baababababbaaaaabbbbbbbbbaabababb", "bbbbb", "aabaabbbaabababbababaaaaabbbbaababaabbabbbbbbaabbaaabbababbbabbabbbaabbbab", "bbaabbbbaabbaaaaaabbbaabababbbaabaaabbbbbabaababbbaababbbaaabaaabaaaababbbbaabbaababb", "aaababbaaaaabaabababbabaabbbbabbaba"]

print(len(A))
print(Solution().solve(A))