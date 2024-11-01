class Solution {
    public long maxSum(Long[] arr) {
        
        List<Long> arrList = Arrays.asList(arr);
        
        // Sort the list in ascending order
        Collections.sort(arrList);
        
        // Create a list to store the final arrangement
        List<Long> finalArrangement = new ArrayList<>();
        
        int start = 0;
        int end = arrList.size() - 1;
        
        // Arrange elements alternately from start and end
        while (start <= end) {
            if (start != end) {
                finalArrangement.add(arrList.get(start));
                finalArrangement.add(arrList.get(end));
            } else {
                // If only one element remains (odd-sized array), add it once
                finalArrangement.add(arrList.get(start));
            }
            start++;
            end--;
        }
        
        long sum = 0;
        
        // Calculate the sum of absolute differences in the final arrangement
        for (int i = 0; i < finalArrangement.size() - 1; i++) {
            sum += Math.abs(finalArrangement.get(i + 1) - finalArrangement.get(i));
        }
        
        // Add the absolute difference between the last and the first element
        int lastIndex = finalArrangement.size() - 1;
        sum += Math.abs(finalArrangement.get(0) - finalArrangement.get(lastIndex));
        
        return sum;
    }
}
