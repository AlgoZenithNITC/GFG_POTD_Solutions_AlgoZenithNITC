import java.util.*;

class Solution {
    public int lis(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        
        int max = lis[0];
        for (int i = 1; i < arr.length; ++i) {
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}

