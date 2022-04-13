class Solution:
    def process(self, string):
        t = []
        u = None
        d = {}
        for ch in string:
            if ch.islower():
                oldCount = d.get(ch, 0)
                d[ch] = oldCount + 1
            else:
                t.append((u, d))
                d = {}
                u = ch

        t.append((u, d))

        return t

    def isOkay(self, a, b):
        for k in a.keys():
            if k not in b.keys():
                return False
            elif a[k] > b[k]:
                return False
        return True

    def match(self, p, q):
        if len(p) != len(q):
            return False

        n = len(p)
        for i in range(n):
            ep = p[i]
            eq = q[i]

            if ep[0] != eq[0]:
                return False
            if not self.isOkay(ep[1], eq[1]):
                return False

        return True

    def camelMatch(self, queries, pattern):
        p = self.process(pattern)
        print(p)
        ans = []
        for query in queries:
            q = self.process(query)
            print(q)
            ans.append(self.match(p, q))

        return ans


queries = ["uAxaqlzahfialcezsLfj", "cAqlzyahaslccezssLfj", "AqlezahjarflcezshLfj", "AqlzofahaplcejuzsLfj", "tAqlzahavslcezsLwzfj", "AqlzahalcerrzsLpfonj", "AqlzahalceaczdsosLfj", "eAqlzbxahalcezelsLfj"]
pattern = "AqlzahalcezsLfj"
# [true,true,true,true,true,true,true,true] expected output

print(Solution().camelMatch(queries, pattern))

queries = ["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"]
pattern = "FoBa"
# [true,false,true,false,false]

print(Solution().camelMatch(queries, pattern))





