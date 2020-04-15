def set_bit(i, n):
    return n | (1 << i)

def generate_gray_code(n):
    all_codes = [0, 1]
    for i in range(1, n):
        new_codes = list(reversed(list(map(lambda x: set_bit(i, x), all_codes))))
        all_codes += new_codes
    return all_codes

print(generate_gray_code(3))