class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here\
        int n = arr.size();
        
        // Iterate over the list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if arr.get(j) is equal to i
                if (arr.get(j) == i) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, temp);
                    break;
                }
            }
        }

        // Iterate over the list
        for (int i = 0; i < n; i++) {
            // If not present, set to -1
            if (arr.get(i) != i) {
                arr.set(i, -1);
            }
        }

        return arr;
    }
}
