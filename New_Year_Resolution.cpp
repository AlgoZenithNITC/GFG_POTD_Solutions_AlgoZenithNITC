class Solution{
    public:
    bool calculate(int n, int coins[], int sum, map<pair<int, int>, bool>& mp){
        if(n == 0){
            if(sum != 0 and (sum%20 == 0 or sum%24 == 0 or sum%2024 == 0)){
                return true;
            }
            return false;
        }
        if(mp.find({n, sum}) != mp.end()){
            return mp[{n, sum}];
        }
        bool include = calculate(n - 1, coins, sum + coins[n - 1], mp);
        bool exclude = calculate(n - 1, coins, sum, mp);
        mp[{n, sum}] = include or exclude;
        return mp[{n, sum}];
    }
    int isPossible(int N , int coins[]){
        map<pair<int, int>, bool> mp;
        return calculate(N, coins, 0, mp);
    }
};
