class Solution {
    public int substrCount(String s, int k) {
       
       
       
         int n = s.length();
        if (n < k) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int distinct = 0, ans = 0;

  
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) == 1) distinct++;
        }

        if (distinct == k - 1) ans++;

    
        for (int i = k; i < n; i++) {
            char removeChar = s.charAt(i - k);
            freq.put(removeChar, freq.get(removeChar) - 1);
            if (freq.get(removeChar) == 0) {
                freq.remove(removeChar);
                distinct--;
            }

            char addChar = s.charAt(i);
            freq.put(addChar, freq.getOrDefault(addChar, 0) + 1);
            if (freq.get(addChar) == 1) {
                distinct++;
            }

            if (distinct == k - 1) ans++;
        }

        return ans;
       
       
       
    }
}
