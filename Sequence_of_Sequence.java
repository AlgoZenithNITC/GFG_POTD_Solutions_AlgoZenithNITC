class Solution{
    static int numberSequence(int m, int n){
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < m + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0 || i < j) {
                    row.add(0);
                } else if (j == 1) {
                    row.add(i);
                } else {
                    row.add(dp.get(i - 1).get(j) + dp.get(i / 2).get(j - 1));
                }
            }
            dp.add(row);
        }
        return dp.get(m).get(n);
    }
}
