openings = ['{', '[', '(']
closings = ['}', ']', ')']

def isBracket(c):
    allowedChars = openings + closings
    return c in allowedChars

def isOpening(c):
    return c in openings

def isMatching(l, r):
    for i in range(len(openings)):
        if l == openings[i] and r == closings[i]:
            return True
    return False

def balancedBrackets(string):
    s = []
    for c in string:
        if not isBracket(c):
            continue
        
        if isOpening(c):
            s.append(c)
        else:
            if len(s) == 0:
                return False
            if not isMatching(s[-1], c):
                return False
            s.pop()
    return len(s) == 0

