class Solution {
    public long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        List<Pair<Integer, Pair<Integer, Integer>>> dp = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            dp.add(new Pair<>(Math.abs(arr[i] - brr[i]), new Pair<>(arr[i], brr[i])));
        }
        
        Collections.sort(dp, (a, b) -> b.getKey() - a.getKey());
        
        long ans = 0;
        for (Pair<Integer, Pair<Integer, Integer>> pair : dp) {
            if (x == 0) {
                ans += pair.getValue().getSecond();
            } else if (y == 0) {
                ans += pair.getValue().getFirst();
            } else {
                if (pair.getValue().getFirst() > pair.getValue().getSecond()) {
                    x--;
                    ans += pair.getValue().getFirst();
                } else {
                    y--;
                    ans += pair.getValue().getSecond();
                }
            }
        }
        return ans;
    }
    
    private static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}

