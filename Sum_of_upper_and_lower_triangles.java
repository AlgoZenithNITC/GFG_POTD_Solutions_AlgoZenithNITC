class Solution{
    static ArrayList<Integer> sumTriangles(int matrix[][], int n){
       int upper_sum = 0, lower_sum = 0;
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i <= j){
                    upper_sum += matrix[i][j];
                }
                if(i >= j){
                    lower_sum += matrix[i][j];
                }
            }
        }
        ans.add(upper_sum);
        ans.add(lower_sum);
        return ans;
    }
}
