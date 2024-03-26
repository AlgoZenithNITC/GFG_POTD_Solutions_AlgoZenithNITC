import java.util.*;

class Solution {
    public boolean isAdditiveSequence(String str) {
        int n = str.length();
        if (n < 3)
            return false;
        String ans, s1;
        for (int i = 0; i < Math.min(n - 1, 10); i++) {
            s1 += str.charAt(i);
            String s2 = "";
            for (int j = i + 1; j < Math.min(n, 10); j++) {
                s2 += str.charAt(j);
                ans = s1 + s2;
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                while (ans.length() < n) {
                    int sum = a + b;
                    String s = Integer.toString(sum);
                    if (n - ans.length() < s.length())
                        break;
                    ans += s;
                    a = b;
                    b = sum;
                    if (ans.equals(str))
                        return true;
                }
            }
        }
        return false;
    }
}
