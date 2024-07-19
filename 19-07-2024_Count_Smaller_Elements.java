class Solution {
    public int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        
        return ans;
    }
}
