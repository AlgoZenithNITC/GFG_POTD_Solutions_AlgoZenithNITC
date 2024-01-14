class Solution{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n){
        Set<Integer> s = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int number = 0;
            for (int j = 0; j < n; j++) {
                number += (matrix[i][j] << j);
            }
            if (!s.contains(number)) {
                s.add(number);
            } else {
                ans.add(i);
            }
        }
        return ans;
    }
}
