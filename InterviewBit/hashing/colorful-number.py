class Solution:
    # @param A : integer
    # @return an integer
    def colorful(self, number):
        products = []
        while number:
            products.append(number % 10)
            number //= 10
        products.append(1)
        products = list(reversed(products))
        for i in range(1, len(products)):
            products[i] *= products[i-1]

        # print(products)
        visited = {}
        for i in range(len(products)):
            for j in range(i+1, len(products)):
                p = products[j] / products[i]
                # print(p)
                if p in visited:
                    return 0
                visited[p] = True
        return 1


print(Solution().colorful(3245))