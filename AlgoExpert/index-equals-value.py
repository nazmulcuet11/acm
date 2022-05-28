# def indexEqualsValue(array):
#     l, r = 0, len(array) - 1
#     while l < r:
#         m = (l + r) // 2
#         if array[m] >= m:
#             r = m
#         else:
#             l = m + 1
#     if l < len(array) and array[l] == l:
#         return l
#     return -1


def indexEqualsValue(array):
    def find(l, r):
        if l > r:
            return -1
        if l == r:
            return l if array[l] == l else -1

        m = (l + r) // 2
        if array[m] >= m:
            return find(l, m)
        else:
            return find(m + 1, r)

    return find(0, len(array) - 1)
