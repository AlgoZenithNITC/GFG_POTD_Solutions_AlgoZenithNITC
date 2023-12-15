class Solution{
	public:
		int nthPoint(int n){
		    int zeroth_step = 1, first_step = 1, steps = 0, mod = 1e9 + 7;
		    for(int ith_step = 2; ith_step <= n; ith_step++){
		        steps = (first_step%mod + zeroth_step%mod)%mod;
		        zeroth_step = first_step;
		        first_step = steps;
		    }
		    return first_step;
		}
};
