class Solution{
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> pattern(int N){
       if(N <= 0){
           ans.add(N);
           return ans;
        }
        ans.add(N);
        pattern(N - 5);
        ans.add(N);
        return ans;
    }
}
