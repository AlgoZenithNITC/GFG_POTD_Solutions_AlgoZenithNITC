class Solution {
    public String caseSort(String s) {
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) lower.add(c);
            else upper.add(c);
        }

        Collections.sort(lower);
        Collections.sort(upper);

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(lower.get(i++));
            } else {
                result.append(upper.get(j++));
            }
        }

        return result.toString();
    }
}
