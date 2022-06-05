from collections import defaultdict, deque


class Solution:
    def findAllRecipes(self, recipes, ingredients, supplies):
        n = len(ingredients)
        g = defaultdict(list)
        indegree = defaultdict(int)
        for i in range(n):
            ingredient = ingredients[i]
            indegree[recipes[i]] = len(ingredient)
            for item in ingredient:
                g[item].append(recipes[i])

        q = deque([])
        for s in supplies:
            q.append(s)

        ans = []
        while len(q) > 0:
            t = q.popleft()
            for r in g[t]:
                indegree[r] -= 1
                if indegree[r] == 0:
                    q.append(r)
                    ans.append(r)

        return ans
