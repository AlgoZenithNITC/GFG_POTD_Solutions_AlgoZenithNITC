class Solution {
public:
	int sumOfPowers(int a, int b){
	    int ans = 0;
        for(int i = a; i <= b; i++){
            int num = i;
            for(int j = 2; j*j <= i; j++){
                while(num%j == 0){
                    ans++;
                    num /= j;
                }
            }
            if(num > 1){
                ans++;
            }
        }
        return ans;
	}
};
