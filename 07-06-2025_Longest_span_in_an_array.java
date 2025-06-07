class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n=a1.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(sum,-1);
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=a1[i]-a2[i];
            if(map.containsKey(sum)) ans=Math.max(ans,i-map.get(sum));
            else map.put(sum,i);
        }
        return ans;
    }
}