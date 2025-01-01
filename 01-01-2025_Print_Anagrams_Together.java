class Solution {
    public List<List<String>> anagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        
        // Grouping anagrams
        for (String str : arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        
        // Collecting results
        List<List<String>> result = new ArrayList<>(map.values());
        
        // Sorting groups lexicographically
        result.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        return result;
    }
}
