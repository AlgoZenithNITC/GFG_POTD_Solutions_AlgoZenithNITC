class Solution {
    public boolean canPair(int[] nums, int k){
        if (nums.length % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            int y = i % k;
            if (mp.getOrDefault((k - y) % k, 0) != 0) {
                mp.put((k - y) % k, mp.get((k - y) % k) - 1);
            } else {
                mp.put(y, mp.getOrDefault(y, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
