def is_palin(i, j, s):
    while i < j:
        if s[i] != s[j]:
            return False
        i += 1
        j -= 1
    return True

palin_indexes = []
def calculate_indexes(S):
    global palin_indexes

    palin_indexes = []
    for i in range(len(S)):
        palins_of_i = []
        for j in range(i, len(S)):
            if is_palin(i, j, S):
                palins_of_i.append(j)
        palin_indexes.append(palins_of_i)


comb = []
solutions = []
main_str = ""
def solve(i):
    global palin_indexes, comb, solutions, main_str
    if i >= len(main_str):
        joind = ''.join(comb)
        if main_str == joind:
            solutions.append(comb[:])
        return
    
    palins_of_i = palin_indexes[i]
    for j in palins_of_i:
        t = main_str[i:j+1]
        comb.append(t)
        solve(j+1)
        comb.pop()


class Solution:
    # @param A : string
    # @return a list of list of strings
    def partition(self, A):
        global comb, solutions, main_str
        calculate_indexes(A)
        # print(palin_indexes)

        solutions = []
        comb = []
        main_str = A
        solve(0)
        return sorted(solutions)

print(Solution().partition("aab"))