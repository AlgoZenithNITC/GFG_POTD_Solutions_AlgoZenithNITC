class Solution{
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = curr.clone();
        }
        int lcs = curr[n];
        return n + m - lcs;
    }
}
