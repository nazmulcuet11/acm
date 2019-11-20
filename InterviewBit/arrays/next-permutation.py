def next_permutation(a):
    i = len(a) - 2
    while i >=0 and a[i] >= a[i+1]:
        i -= 1
    if i < 0:
        return None
    for j in range(len(a)-1, i, -1):
        if a[j] > a[i]:
            a[i], a[j] = a[j], a[i]
            a[i+1: len(a)] = sorted(a[i+1:len(a)])
            break
    return a

class Solution:
    # @param A : list of integers
    # @return a list of integers
    def nextPermutation(self, A):
        x = next_permutation(A)
        if x == None:
            return sorted(A)
        return x


print(Solution().nextPermutation([1, 2, 3]))
print(Solution().nextPermutation([3, 2, 1]))
print(Solution().nextPermutation([1, 1, 5]))
print(Solution().nextPermutation([20, 50, 113]))
print(Solution().nextPermutation([444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52]))