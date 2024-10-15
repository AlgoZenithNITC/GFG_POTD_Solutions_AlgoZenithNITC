// User function Template for Java

class Solution {
    static int subArraySum(int arr[], int tar) {
        int cnt = 0;
        int currSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // Intialvalue
        for(int i = 0; i<arr.length; i++){
            currSum += arr[i];
            int prefixSum = currSum - tar;
            if(map.containsKey(prefixSum)){
                cnt += map.get(prefixSum);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return cnt;
    }
}
