class Solution
{
	public:
		long long int PowMod(long long int x,long long int n,long long int m)
		{
		    // Code here
		    long long int res = 1;
		    while(n > 0){
		        if(n % 2 == 1){
		            res = ((res % m) * (x % m)) % m;
		        }
		        x = (x * x) % m;
		        n /= 2;
		    }
		    return res;
		}
};
