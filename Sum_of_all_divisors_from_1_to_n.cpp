class Solution{
public:
    long long sumOfDivisors(int N){
        long long ans = 0;
        for(int i = 1; i <= N; i++){
            if(N%i == 0){
                ans += N;
            }else{
                ans += i*(N/i);
            }
        }
        return ans;
    }
};
