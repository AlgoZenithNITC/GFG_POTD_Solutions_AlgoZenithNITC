class Solution{
    static int findWinner(int n, int A[]){
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans ^= A[i];
        }
        if(ans == 0 || n%2 == 0){
            return 1;
        }
        return 2;
    }
}
