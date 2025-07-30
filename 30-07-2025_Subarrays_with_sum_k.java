public int cntSubarrays(int[] arr, int k) {
    int n = arr.length;
    Map<Integer, Integer> mp = new HashMap<>();
    int sum = 0, count = 0;
    mp.put(0, 1);

    for (int i = 0; i < n; i++) {
        sum += arr[i];

        if (mp.containsKey(sum - k)) {
            count += mp.get(sum - k);
        }

        mp.put(sum, mp.getOrDefault(sum, 0) + 1);
    }

    return count;
}
