class Solution{
    static int LCS(String first, String second){
        int n = first.length();
        int[] prev = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int[] curr = new int[n + 1];
            for(int j = 1; j <= n; j++){
                if(first.charAt(i - 1) == second.charAt(j - 1)){
                    curr[j] = 1 + prev[j - 1];
                }else{
                    int left = curr[j - 1];
                    int top = prev[j];
                    curr[j] = Math.max(left, top);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
    static int minimumNumberOfDeletions(String S) {
        String first = S;
        String second = new StringBuilder(S).reverse().toString();
        return S.length() - LCS(first, second);
    }
}
