class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here 
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); // Sort intervals by start time
        List<int[]> res = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        
        while (i < n) {
            int start = arr[i][0];
            int end = arr[i][1];
            
            // Merge overlapping intervals
            while (i + 1 < n && end >= arr[i + 1][0]) {
                end = Math.max(end, arr[i + 1][1]);
                i++;
            }
            
            res.add(new int[]{start, end}); // Add merged interval as an int[] array
            i++;
        }
        
        return res;
    }
}