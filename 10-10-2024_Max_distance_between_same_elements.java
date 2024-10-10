class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        int n = arr.length;
        int maxD = -1; 
        for (int i = 0; i < n - 1; i++) { 
            for (int j = i + 1; j < n; j++) { 
                // check if two elements are equal 
                if (arr[i] == arr[j]) { 
                    // if yes then calculate the distance 
                    // and update maxD 
                    int temp = Math.abs(j - i); 
                    maxD = maxD > temp ? maxD : temp; 
                } 
            } 
        } 
         // return maximum distance 
        return maxD; 
    }
}
