class Solution{
public:
    int findWinner(int n, int A[]){
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans ^= A[i];
        }
        return ans == 0 or n%2 == 0 ? 1 : 2;
    }
};
