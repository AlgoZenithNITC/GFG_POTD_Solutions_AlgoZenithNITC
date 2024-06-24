class Solution {
    static long sumMatrix(long n, long q) {
        // code here
 return Math.max(0,n-Math.abs(n-q+1));
    }
}
