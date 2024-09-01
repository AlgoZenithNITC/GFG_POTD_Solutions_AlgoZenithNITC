class Solution {
    public int maxPathSum(List<Integer> ar1, List<Integer> ar2) {
        int m = ar1.size(), n = ar2.size();
        int i = 0, j = 0;

        int result = 0, sum1 = 0, sum2 = 0;
    
        while (i < m && j < n) {
            if (ar1.get(i) < ar2.get(j))
                sum1 += ar1.get(i++);
    
            else if (ar1.get(i) > ar2.get(j))
                sum2 += ar2.get(j++);
    
            else {
                result += Math.max(sum1, sum2) + ar1.get(i);
    
                sum1 = 0;
                sum2 = 0;
    
                i++;
                j++;
            }
        }
    
        while (i < m)
            sum1 += ar1.get(i++);
    
        while (j < n)
            sum2 += ar2.get(j++);
    
        result += Math.max(sum1, sum2);
    
        return result;
    }
    
}
