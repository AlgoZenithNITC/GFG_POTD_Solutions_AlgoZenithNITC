class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int v){
        int sum = 0;
        for(ArrayList<Integer> list: adj){
          sum += list.size();
        }
        return sum;
    }
};
