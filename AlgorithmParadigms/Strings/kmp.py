# Great explanation: https://www.youtube.com/watch?v=GTJr8OvyEVQ
#
# Do not get confused! Suffix is used with the pattern not the actual string
# If a suffix of the pattern is also a prefix of the pattern we can
# skip that(prefix) portion and match from there(after the prefix) of the pattern
# with the current charachter(of the main string) at hand.
#
# Beleve me following is a great sample input
# Text: abcxabcdabxabcdabcdabcy
# Pattern: abcdabcy

suffix_table = []
def build_suffix_table(pattern):
    global suffix_table
    suffix_table = [0]
    for i in range(1, len(pattern)):
        j = suffix_table[i-1]
        while j > 0 and pattern[j] != pattern[i]:
            j = suffix_table[j-1]
        if pattern[j] == pattern[i]:
            suffix_table.append(j + 1)
        else:
            suffix_table.append(0)

def kmp_serch(s, p):
    build_suffix_table(p)
    i, j = 0, 0
    while i < len(s):
        if s[i] == p[j]:
            i += 1
            j += 1
        else:
            if j == 0:
                i += 1
            else:
                j = suffix_table[j-1]

        if j == len(p):
            return True

    return False

print(kmp_serch("ABABDABACDABABCABAB", "ABABCABAB"))
print(kmp_serch("ABABDABACDABABCABAB", "ABABCABABD"))
