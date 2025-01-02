class Solution {
    public int countSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                res++;
            }
            if (prefixSums.containsKey(sum - k)) {
                res += prefixSums.get(sum - k);
            }
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}