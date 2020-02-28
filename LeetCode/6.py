class Solution(object):
    def convert(self, s, numRows):
        if numRows == 1:
            return s
        
        rows = [ "" for _ in range(numRows)]
        block_size = 2 * numRows - 2
        for i in range(len(s)):
            ch = s[i]
            row_number = i % block_size
            if row_number >= numRows:
                row_number = 2 * numRows - row_number - 2
            rows[row_number] += ch

        return ''.join(rows)


print(Solution().convert("PAYPALISHIRING", 3))
print(Solution().convert("PAYPALISHIRING", 4))


        