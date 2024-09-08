class Solution {
    public int minJumps(List<Integer> arr) {
        int n = arr.size();
        
        if (n == 1)
            return 0;
        
        int i = 0;
        int jumps = 0;
        
        while (i < n) {
            if (arr.get(i) == 0)
                return -1;
            
            jumps++;
            int m = i;
            
            for (int j = i + 1; j <= i + arr.get(i) && j < n; j++) {
                if (j >= n - 1) 
                    return jumps;
                
                if (arr.get(j) + j >= arr.get(m) + m)
                    m = j;
            }
            
            i = m;
        }
        return jumps;
    }
}

