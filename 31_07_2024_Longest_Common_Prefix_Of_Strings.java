

// User function Template for Java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        String s1 = arr[0];
        String s2 = arr[n-1];
        String ans = "";
        for(int i =0; i<arr[0].length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                ans = ans + (Character.toString(s1.charAt(i)));
            }
            else{
                break;
            }
        }
        if(ans.isEmpty()) return "-1";
        else return ans;
    }
}
