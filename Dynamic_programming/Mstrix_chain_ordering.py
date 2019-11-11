def matrix_chain_ordering(p):
    n = len(p) - 1
    m = [[0] * n][[0] * n]
    s = [[0] * (n - 1)][[0] * (n - 1)]
    for l in range(2, n):
        for i in range(n - l + 1):
            j = i + l - 1
            m[i][j] = -50000
            for k in range(j - 1):
                q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]
                if q < m[i][j]:
                    m[i][j] = q
                    s[i][k] = k
    return m, s

    p = (4, 2, 4, 7)
    a = []
    b = []
    a, b = matrix_chain_ordering(p)
    print(a)
    print(b)
