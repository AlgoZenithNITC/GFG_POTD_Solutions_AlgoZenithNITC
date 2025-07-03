public int longestKSubstr(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int l = 0, r = 0, ans = -1;

    while (r < s.length()) {
        char ch = s.charAt(r);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        while (map.size() > k) {
            char leftChar = s.charAt(l);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            l++;
        }

        if (map.size() == k) {
            ans = Math.max(ans, r - l + 1);
        }

        r++;
    }

    return ans;
}
