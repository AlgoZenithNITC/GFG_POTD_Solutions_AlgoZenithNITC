import java.util.ArrayList;
import java.util.List;

class Solution {
  
    public int findSum(List<Integer> arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) 
            sum += arr.get(i);
        return sum;
    } 

    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(List<Integer> arr) {
        int n = arr.size();
  
        // First partition
        for (int i = 0; i < n - 2; i++) {
            
            // Second Partition
            for (int j = i + 1; j < n - 1; j++) {
                
                // Find sum of all three segments
                int sum1 = findSum(arr, 0, i);
                int sum2 = findSum(arr, i + 1, j);
                int sum3 = findSum(arr, j + 1, n - 1);
                
                // If all three segments have equal sum,
                // then return true
                if (sum1 == sum2 && sum2 == sum3) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
  
        // No possible index pair found
        List<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        return result;
    }
}


