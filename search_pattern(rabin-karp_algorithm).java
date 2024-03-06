
class Solution {
    ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> v = new ArrayList<>();
        int p = pattern.length();
        int t = text.length();
        for (int i = 0; i <= t - p; i++) {
            if (pattern.equals(text.substring(i, i + p))) {
                v.add(i + 1);
            }
        }
        return v;
    }
}
