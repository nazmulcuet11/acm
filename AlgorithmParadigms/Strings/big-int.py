# def multiply(str, num):



# Multiply two non-negative numbers represented as strings 
def multiply(numOne, numTwo):
    n, m = len(numOne), len(numTwo)
    res = [0 for _ in  range(n + m)]
    for i in range(n-1, -1, -1):
        for j in range(m-1, -1, -1):
            x = int(numOne[i]) * int(numTwo[j])
            sum = res[i+j+1] + x
            res[i + j + 1] = sum % 10
            res[i + j]    += sum // 10
    i = 0
    while i < len(res) and res[i] == 0:
        i += 1
    if i == len(res):
        return "0"
    return ''.join(map(lambda x: str(x), res[i::]))

print(multiply("22", "66"))