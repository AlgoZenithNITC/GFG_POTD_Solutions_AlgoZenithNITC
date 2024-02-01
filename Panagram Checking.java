class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        int[] a = new int[26];
        Arrays.fill(a, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                a[s.charAt(i) - 'A']++;
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                a[s.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] == 0) {
                return false;
            }
        }
        return true;
    }

}