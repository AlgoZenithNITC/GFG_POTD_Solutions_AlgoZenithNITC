
class Solution {
    public long[][] multiply(long[][] a, long[][] b, long m) {
       
        long[][] mul = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mul[i][j] = (mul[i][j] + a[i][k] * b[k][j]) % m;
                }
            }
        }
        return mul;
    }

    public long[][] find(long[][] arr, long n, long m) {
        int rows = arr.length;
        int cols = arr[0].length;
        long[][] temp = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            temp[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                temp = multiply(temp, arr, m);
            }
            arr = multiply(arr, arr, m);
            n /= 2;
        }
        return temp;
    }

    public long genFibNum(long a, long b, long c, long n, long m) {
        if (m == 1) return 0;
        if (n == 1 || n == 2) return 1;
        
        long[][] F = {{a, b, 1}, {1, 0, 0}, {0, 0, 1}};
        F = find(F, n - 2, m);
        return (F[0][0] + F[0][1] + F[0][2] * c) % m;
    }
}
