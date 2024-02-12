class Solution{
public:
    long long sequence(int n){
        // code here
        long long int i=1,k,c=1,s=1;
        long long int p=0;
        long long mod=1000000007;
        while(i<=n)
        {
        k=i;
        while(k--)
        {
            s=(s*c)%mod;
            c++;   
        }
        
        p=p+s;
        p=p%mod;
        s=1;
        i++;
        }
        return p;
        }
};