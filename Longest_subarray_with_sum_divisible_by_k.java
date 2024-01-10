class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k){
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int rem = 0;
        for(int i = 0; i < n; i += 1){
            rem = (rem + a[i]%k + k)%k;
            if(rem == 0){
                ans = Math.max(ans, i + 1);
            }else if(!mp.containsKey(rem)){
                mp.put(rem, i);
            }else{
                ans = Math.max(ans, i - mp.get(rem));
            }
        }
        return ans;
    }
}
