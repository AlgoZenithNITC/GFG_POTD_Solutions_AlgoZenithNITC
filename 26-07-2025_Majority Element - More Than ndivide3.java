

class Solution {
    public List<Integer> findMajority(int[] arr) {
        int value = arr.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > value) {
                res.add(entry.getKey());
            }
        }
         Collections.sort(res);
        return res;
    }
}
