class Solution {
    public int romanToDecimal(String s) {
        Map<Character, Integer> val = new HashMap<>();
        val.put('I', 1);
        val.put('V', 5);
        val.put('X', 10);
        val.put('L', 50);
        val.put('C', 100);
        val.put('D', 500);
        val.put('M', 1000);

        int total = 0;
        int i = 0;

        while (i < s.length()) {
            if (i + 1 < s.length() && val.get(s.charAt(i)) < val.get(s.charAt(i + 1))) {
                total += val.get(s.charAt(i + 1)) - val.get(s.charAt(i));
                i += 2;
            } else {
                total += val.get(s.charAt(i));
                i++;
            }
        }

        return total;
    }
}
