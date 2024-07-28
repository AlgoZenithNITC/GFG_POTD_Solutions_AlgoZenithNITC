class Solution {
    String removeDups(String str) {
        // code here
       HashSet<Character> seen = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                ans.append(ch);
                seen.add(ch);
            }
        }

        return ans.toString();
    }
}
