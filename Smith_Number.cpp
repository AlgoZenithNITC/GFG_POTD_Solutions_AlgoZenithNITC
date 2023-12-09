class Solution {
  public:
    int digitsum(int n){
        int ans = 0;
        while(n){
            ans += n%10;
            n /= 10;
        }
        return ans;
    }
    int smithNum(int n){
        int sum = 0, k = n, temp = digitsum(n);
        for(int i = 2; i <= sqrt(n); i++){
            while(n%i == 0){
                sum += digitsum(i);
                n /= i;
            }
        }
        if(n > 1 and n != k){
            sum += digitsum(n);
        }
        return sum == temp;
    }
};
