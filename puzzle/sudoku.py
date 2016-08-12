def cross(A, B):
    "Cross product of elements in A and elements in B"
    return [a + b for a in A for b in B]


digits = '12345678'
rows = 'ABCDEFGHI'
list = cross(rows, digits);
print len(list)
for i in list:
    print i + " ",
