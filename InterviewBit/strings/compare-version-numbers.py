class Solution:
    # @param A : string
    # @param B : string
    # @return an integer
    def compareVersion(self, A, B):
        first_components = [int(num) for num in A.split('.')]
        last_components = [int(num) for num in B.split('.')]

        while len(first_components) < len(last_components):
            first_components.append(0)

        while len(last_components) < len(first_components):
            last_components.append(0)

        for i in range(len(first_components)):
            if first_components[i] > last_components[i]:
                return 1
            if first_components[i] < last_components[i]:
                return -1

        return 0


print(Solution().compareVersion("1.13", "1.2"))
print(Solution().compareVersion("1.13", "1.2.4"))
print(Solution().compareVersion("1.1.5", "1.2.4"))
print(Solution().compareVersion("1.5.1", "1.2.500"))
print(Solution().compareVersion("1.13", "1.13"))