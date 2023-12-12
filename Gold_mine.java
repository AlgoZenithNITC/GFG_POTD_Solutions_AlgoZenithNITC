class Solution{
    static int maxGold(int n, int m, int M[][]){
        int ans = 0;
        for(int j = m - 2; j >= 0; j--){
            for(int i = 0; i < n; i++){
                if(i == 0){
                    if(i + 1 < n){
                        M[i][j] += Math.max(M[i][j + 1], M[i + 1][j + 1]);
                    }else{
                        M[i][j] += M[i][j + 1];
                    }
                }else if(i == n - 1){
                    if(i - 1 >= 0){
                        M[i][j] += Math.max(M[i][j + 1], M[i - 1][j + 1]);
                    }else{
                        M[i][j] += M[i][j + 1];
                    }
                }else{
                    int temp = M[i][j + 1];
                    if(i + 1 < n){
                        temp = Math.max(temp, M[i + 1][j + 1]);
                    }
                    if(i - 1 >= 0){
                        temp = Math.max(temp, M[i - 1][j + 1]);
                    }
                    M[i][j] += temp;
                 }
                 if(j == 0){
                     ans = Math.max(M[i][j], ans);
                 }
            }
        }
        return ans;
    }
}
