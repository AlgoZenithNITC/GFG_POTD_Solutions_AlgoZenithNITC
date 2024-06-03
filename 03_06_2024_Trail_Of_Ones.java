class Solution {
    static int numberOfConsecutiveOnes(int n) {
        int m=1000000007;long ans=1;int x=0,y=1;
        for(int i=3;i<=n;i++){
            ans=(ans*2+x+y)%m;
            x%=m;
            y%=m;
            int t=x;
            x=y;
            y=y+t;
        }
        return (int)ans;
    }
}
