public class Solution {
    public int minRepeats(String s1, String s2) {
        int minRepeats = (s2.length() + s1.length() - 1) / s1.length();
        StringBuilder repeatedS1 = new StringBuilder();
        for (int i = 0; i < minRepeats; i++) {
            repeatedS1.append(s1);
        }
        if (repeatedS1.indexOf(s2) != -1) {
            return minRepeats;
        }
        repeatedS1.append(s1);
        if (repeatedS1.indexOf(s2) != -1) {
            return minRepeats + 1;
        }
        return -1;
    }
}
