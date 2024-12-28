class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        Set<List<Integer>> resultSet = new HashSet<>();
    
    int len = arr.length;
    
    Map<Integer, List<int[]>> sumWithPair = new HashMap<>();
    
    for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
            int sum = arr[i] + arr[j];
            
            sumWithPair.putIfAbsent(sum, new ArrayList<>());
            sumWithPair.get(sum).add(new int[]{i, j});
        }
    }
    
    for (int i = 0; i < len; i++) {
        int complement = -arr[i];
        
        if (sumWithPair.containsKey(complement)) {
            for (int[] pair : sumWithPair.get(complement)) {
                if (i != pair[0] && i != pair[1]) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(i, pair[0], pair[1]));
                    Collections.sort(triplet);
                    resultSet.add(triplet);
                }
            }
        }
    }
    
    return new ArrayList<>(resultSet);
    }
}
