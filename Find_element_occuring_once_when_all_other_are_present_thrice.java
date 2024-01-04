class Solution {
    static int singleElement(int[] arr , int N) {
        List<Integer> count = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            count.add(0);
        }
        for (int bit = 0; bit < 32; bit++) {
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    count.set(bit, count.get(bit) + 1);
                }
            }
        }
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            if (count.get(bit) % 3 != 0) {
                ans += (1 << bit);
            }
        }
        return ans;
    }
}
