int kthElement(int* a, int n, int* b, int m, int k) {
    int i = 0, j = 0, pos = 0, store = 0;
    
    while (pos != k && i < n && j < m) {
        if (a[i] < b[j]) {
            i++;
            store = 0;
        } else {
            j++;
            store = 1;
        }
        pos++;
    }
    
    while (pos != k && i < n) {
        i++;
        store = 0;
        pos++;
    }
    
    while (pos != k && j < m) {
        j++;
        store = 1;
        pos++;
    }
    
    return store == 0 ? a[i - 1] : b[j - 1];
}
