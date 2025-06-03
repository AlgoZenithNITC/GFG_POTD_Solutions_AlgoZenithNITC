class Solution {
    
    
    private int atMostK(String s, int k) {
        int n = s.length();
        int[] count = new int[26]; // for lowercase English letters
        int i = 0, res = 0, distinct = 0;

        for (int j = 0; j < n; j++) 
        {
            if (count[s.charAt(j) - 'a'] == 0) {
                distinct++;
            }
            count[s.charAt(j) - 'a']++;

            while (distinct > k) {
                count[s.charAt(i) - 'a']--;
                if (count[s.charAt(i) - 'a'] == 0) {
                    distinct--;
                }
                i++;
            }

            res += j - i + 1;
            
            
        }
        
        return res;
        
    }

    public int countSubstr(String s, int k) {
        // your code here
        return atMostK(s, k) - atMostK(s, k - 1);
    }
}
