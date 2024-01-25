class Solution{   
public:
    int solve(int Num1, int Num2){
        //sieve start
        int max_num = 9999;
        vector<int> prime(10001, 1);
        prime[1] = 0;
        for(int i = 2; i*i <= max_num; i++){
            if(prime[i]){
                for(int j = i*i; j <= max_num; j += i){
                    prime[j]=0;
                }
            }
        }
        //sieve end
        vector<int> dp(10001,-1), vis(10001); 
        queue<int> q;
        q.push(Num1);
        dp[Num1] = 0, vis[Num1] = 0;
        while(!q.empty()){
            int current = q.front();
            q.pop();
            if(vis[current]){
                continue;
            }
            vis[current] = 1;
            string s = to_string(current);
            for(int i = 0; i < 4; i++){
                for(char ch = '0'; ch <= '9'; ch++){
                    if(ch == s[i] or (ch == '0' and i == 0)){
                        continue;
                    }
                    string next = s;
                    next[i] = ch;
                    int next_num = stoi(next);
                    if(prime[next_num] and dp[next_num] == -1){
                        dp[next_num] = 1 + dp[current];
                        q.push(next_num);
                    }
                    if(next_num == Num2){
                        return dp[next_num];
                    }
                }
            }
        }
        return dp[Num2];
    }
};
