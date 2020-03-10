ROMAN_FOR_INT = {1: 'I', 4: 'IV', 5: 'V', 9: 'IX', 10: 'X', 40: 'XL', 50: 'L', 90: 'XC', 100: 'C', 400: 'CD', 500: 'D', 900: 'CM', 1000: 'M'}
keys = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]

class Solution:
    # @param A : integer
    # @return a strings
    def intToRoman(self, int_val):
        roman_val = ""
        while int_val > 0:
            for key in keys:
                if int_val - key >= 0:
                    int_val -= key
                    roman_val += ROMAN_FOR_INT[key]
                    break

        return roman_val

print(Solution().intToRoman(14))