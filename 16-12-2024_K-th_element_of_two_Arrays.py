def kthElement(a, n, b, m, k):
    i = 0
    j = 0
    pos = 0
    store = 0
    
    while pos != k and i < n and j < m:
        if a[i] < b[j]:
            i += 1
            store = 0
        else:
            j += 1
            store = 1
        pos += 1
    
    while pos != k and i < n:
        i += 1
        store = 0
        pos += 1
    
    while pos != k and j < m:
        j += 1
        store = 1
        pos += 1
    
    return a[i - 1] if store == 0 else b[j - 1]
