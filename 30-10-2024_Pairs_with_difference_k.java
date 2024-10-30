class Solution {
    public int countPairsWithDiffK(int[] arr, int k) {
        int maxi = 0;
        int size = arr.length, count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxi)
                maxi = arr[i];
        }
        int[] ht = new int[maxi + 1];
        for (int i = 0; i < size; i++) ht[arr[i]]++;
        for (int i = 0; i < size; i++) {
            int curr = arr[i];
            if ((curr + k <= maxi) && ht[curr + k]>0) {
                count += ht[curr + k];
            }
        }
        return count;
    }
}
