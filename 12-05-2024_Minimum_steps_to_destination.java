

// User function Template for Java

class Solution {
    static int minSteps(int d) {
        // code here
        int step = 0;
        int sum = 0;
        
        while(sum<d || (sum-d)%2!=0){
            step++;
            sum+=step;
        }
        
        return step ;
    }
}
