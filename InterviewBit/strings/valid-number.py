def contains_other_char(s, permitted_chars):
    for ch in s:
        invalid = True
        for p in permitted_chars:
            if p == ch:
                invalid = False
                break
        if invalid:
            return True
    return False

def number_of_char(s, target):
    cnt = 0
    for ch in s:
        if ch == target:
            cnt += 1
    return cnt

def is_number_only(s):
    for ch in s:
        if not ch.isnumeric():
            return False
    return True

def sub_script_valid(s):
    if len(s) == 0:
        return False
    if number_of_char(s, '.') > 1:
        return False
    if number_of_char(s, '+') > 1:
        return False
    if number_of_char(s, '-') > 1:
        return False
    if s.find('+') > 0 or (s.find('+') == 0 and len(s) == 1):
        return False
    if s.find('-') > 0 or (s.find('-') == 0 and len(s) == 1):
        return False
    
    dot_index = s.find('.')
    if dot_index != -1:
        if dot_index == len(s) - 1:
            return False
        if not is_number_only(s[dot_index+1:]):
            return False
    
    return True

def super_script_valid(s):
    if not sub_script_valid(s):
        return False
    if number_of_char(s, '.') > 0:
        return False
    return True

class Solution:
    # @param A : string
    # @return an integer
    def isNumber(self, A):
        A = A.strip()
        permitted_chars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', 'e', '.']
        if contains_other_char(A, permitted_chars):
            return 0

        if number_of_char(A, '.') > 1:
            return 0

        if number_of_char(A, 'e') > 1:
            return 0

        e_index = A.find('e')
        if e_index != -1:
            if not super_script_valid(A[e_index+1:]):
                return 0
            if not sub_script_valid(A[:e_index]):
                return 0
        else:
            if not sub_script_valid(A):
                return 0

        return 1


print(Solution().isNumber("1u") == 0)
print(Solution().isNumber("0.1e10") == 1)
print(Solution().isNumber("-01.1e-10") == 1)
print(Solution().isNumber("0xFF") == 0)
print(Solution().isNumber("3.") == 0)
print(Solution().isNumber("3e0.1") == 0)
print(Solution().isNumber("1f") == 0)
print(Solution().isNumber("1000L") == 0)
print(Solution().isNumber("008") == 1)
print(Solution().isNumber("0+") == 0)
print(Solution().isNumber("0+") == 0)
print(Solution().isNumber("+") == 0)
print(Solution().isNumber("+0") == 1)
print(Solution().isNumber("     0.1") == 1)
print(Solution().isNumber("0.1    ") == 1)
