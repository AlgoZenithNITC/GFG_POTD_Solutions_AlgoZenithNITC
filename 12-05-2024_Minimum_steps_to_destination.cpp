// User function Template for C++

class Solution {
  public:
    int minSteps(int d) {
        // code here
        int step =0 , sum =0;
        
        while(sum<d or ((sum-d)%2!=0)){
            step++;
            sum+=step;
        }
        
        return step ;
    }
};
