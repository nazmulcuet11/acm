subsets = []
def generate_subset(i, s, a):
    global subsets
    if i >= len(a):
        subsets.append(s.copy())
        return 
    
    generate_subset(i + 1, s, a)
    s.append(a[i])
    generate_subset(i + 1, s, a)
    s.pop()


def generate_subset_iterative(a):
    a.sort()
    subsets = [[]]
    for e in a:
        new_sets = []
        for s in subsets:
            new_sets.append(s + [e])
        subsets += new_sets
    return sorted(subsets)

class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    def subsets(self, A):
        global subsets
        subsets = []
        generate_subset(0, [], sorted(A))
        return sorted(subsets)


print(Solution().subsets([1, 2, 3]))
print(generate_subset_iterative([1, 2, 3]))