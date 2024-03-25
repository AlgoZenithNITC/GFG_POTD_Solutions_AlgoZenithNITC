class Solution {
    
    void generate(String str, int ones, int zeroes, ArrayList<String>ans, int n){
        if(str.length() == n){
            ans.add(str);
            return;
        }
        generate(str + "1", ones + 1, zeroes, ans, n);
        if(ones > zeroes){
            generate(str + "0", ones, zeroes + 1, ans, n);
        }
    }
    
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String>ans = new ArrayList<>();
        String s = "";
        generate(s, 0, 0, ans, N);
        return ans;
    }
}
