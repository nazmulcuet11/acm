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
    def subsetsWithDup(self, A):
        subsets = generate_subset_iterative(A)
        unique_subsets = []
        seen_subsets = {}
        for s in subsets:
            key = tuple(s)
            if key not in seen_subsets:
                seen_subsets[key] = True
                unique_subsets.append(s)
        return unique_subsets
        

print(generate_subset_iterative([1, 2, 3]))
print(Solution().subsetsWithDup([1, 2, 2]))
        
