class Solution:
    # @param A : string
    # @return a list of integers
    def flip(self, A):
        a = [(ord(A[i]) - ord('0')) for i in range(len(A))]
        
        cntOne = 0
        for i in range(len(a)):
            cntOne += a[i]

        if cntOne == len(a):
            return []

        p = []
        i = 0
        while i < len(a):
            cnt = 1
            while i < len(a)-1 and a[i] == a[i+1]:
                cnt += 1
                i += 1
            if a[i] == 1:
                cnt = -cnt
            p.append(cnt)
            i += 1

        # print(p)

        q = [0 for _ in range(len(p))]
        q[0] = 0 if p[0] < 0 else p[0]
        for i in range(1, len(p)):
            t = p[i]+q[i-1]
            q[i] = 0 if t < 0 else t

        r = [0 for _ in range(len(p))]
        r[len(p)-1] = 0 if p[len(p)-1] < 0 else p[len(p)-1]
        for i in range(len(p)-2, -1, -1):
            t = p[i]+r[i+1]
            r[i] = 0 if t < 0 else t

        # print(r)

        x, mx = -1, 0
        for i in range(len(q)-1, -1, -1):
            if q[i] >= mx:
                x, mx = i, q[i]

        y = -1
        for i in range(len(r)):
            if r[i] == mx:
                y = i
                break
        
        # print(q)
        # print(y, x)

        s, t = 0, 0
        for i in range(y):
            s += p[i] if p[i] >= 0 else -p[i]
        for i in range(x+1):
            t += p[i] if p[i] >= 0 else -p[i]

        return [s+1, t]

print(Solution().flip("010"))
print(Solution().flip("0111000100010"))
print(Solution().flip("111"))
print(Solution().flip("1101010001"))