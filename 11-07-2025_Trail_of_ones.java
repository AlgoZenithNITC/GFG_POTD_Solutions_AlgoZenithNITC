class Solution {
    public int countConsec(int n) {
        // code here

        if (n == 0) return 0;

        int[] a = new int[n + 1]; // Ends with 0
        int[] b = new int[n + 1]; // Ends with 1

        a[1] = b[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int total = (int) Math.pow(2, n);
        int withoutConsec = a[n] + b[n];
      
        return total - withoutConsec;
    }

    
}
