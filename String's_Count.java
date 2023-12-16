class Solution { 
    static long countStr(long n){
	    long ans = ((1 + 2*n) + (n*(n*n - 1)/2));
	    return ans;
	}
} 
