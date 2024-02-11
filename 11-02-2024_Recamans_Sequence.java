//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        ans.add(0);
        for (int i = 1; i < n; i++) {
            int prev = ans.get(i - 1);
            if (prev - i > 0 && !mp.containsKey(prev - i)) {
                ans.add(prev - i);
                mp.put(prev - i, 1);
            } else {
                ans.add(prev + i);
                mp.put(prev + i, 1);
            }
        }
        return ans;
    }
}
