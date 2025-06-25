class Solution {
    boolean sameFreq(String s) 
    {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        if (allSame(freq)) {
            return true;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;

                if (allSame(freq)) {
                    return true;
                }

                freq[i]++;
            }
        }

        return false;
    }

    boolean allSame(int[] freq) 
    {
        int check = 0;
        int i = 0;

      
        for (; i < 26; i++) {
            if (freq[i] > 0) {
                check = freq[i];
                break;
            }
        }

        for (int j = i + 1; j < 26; j++) {
            if (freq[j] > 0 && freq[j] != check) {
                return false;
            }
        }

        return true;
    }
}
