class Solution{
    public:
    int isPossible(int N , int coins[]){
        int total = accumulate(coins, coins + N, 0);
        vector<vector<bool>> possibility(N + 1, vector<bool>(total + 1));
        for(int i = 0; i <= N; i++){
            possibility[i][0] = true;
        }
        for(int i = 1; i <= total; i++){
            possibility[0][i] = false;
        }
        for(int idx = 1; idx <= N; idx++){
            for(int sum = 1; sum <= total; sum++){
                if(sum < coins[idx - 1])
                    possibility[idx][sum] = possibility[idx - 1][sum];
                if(sum >= coins[idx - 1])
                    possibility[idx][sum] = possibility[idx - 1][sum]
                                   or possibility[idx - 1][sum - coins[idx - 1]];
            }
        }
        for(int sum = 1; sum <= total; sum++){
            if((sum%20 == 0 or sum%24 == 0 or sum == 2024) and possibility[N][sum])
                return true;
        }
        return false;
    }
};
