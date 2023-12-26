class Solution {
     public static int findSum(int r1, int c1, int r2, int c2, int n, int m, int[][] pref){
        int sum = pref[r2][c2];
        if ((c1 - 1) >= 0)
        {
            sum -= pref[r2][c1 - 1];
        }
        if ((r1 - 1) >= 0)
        {
            sum -= pref[r1 - 1][c2];
        }
        if ((c1 - 1) >= 0 && (r1 - 1) >= 0)
        {
            sum += pref[r1 - 1][c1 - 1];
        }
        return sum;
    }

   
        public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            
        int[][] pref = new int[n][m];
        for(int i = 0; i<n; i++) 
        {
            for(int j = 0; j<m; j++) 
            {
                pref[i][j] = 0;
            }
        }

        // Row-wise sum.
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                pref[i][j] = mat[i][j];
                if ((j - 1) >= 0)
                {
                    pref[i][j] += pref[i][j - 1];
                }
            }
        }

        // Column-wise sum.
        for (int j = 0; j < m; j++)
        {
            for (int i = 0; i < n; i++)
            {
                if ((i - 1) >= 0)
                {
                    pref[i][j] += pref[i - 1][j];
                }
            }
        }

        int ans = 0;
        int r1=0;
        int r2=0;
        int c1=0;
        int c2=0;
         int[] r1r2c1c2 = new int[4];
        for ( r1 = 0; r1 < n; r1++)
        {
            for ( c1 = 0; c1 < m; c1++)
            {
                for ( r2 = r1; r2 < n; r2++)
                {
                    for ( c2 = c1; c2 < m; c2++)
                    {
                        // Find the sum of submatrix(r1, c1, r2, c2).
                        int sum = findSum(r1, c1, r2, c2, n, m, pref);

                        if (sum == 0)
                        {
                            int submatrixSize = (r2 - r1 + 1) * (c2 - c1 + 1);
                                             if(ans<submatrixSize){
                                ans=submatrixSize;
                            //    System.out.println(r1+" "+r2+"       ");
                            
                                r1r2c1c2=new int[]{r1,r2,c1,c2};
                            }
                            if(ans==submatrixSize){
                                if(c1<r1r2c1c2[2])r1r2c1c2=new int[]{r1,r2,c1,c2};
                            }
                            
                        }
                    }
                }
            }
        }
        int ii=0;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        r1=r1r2c1c2[0];
        r2=r1r2c1c2[1];
        c1=r1r2c1c2[2];
        c2=r1r2c1c2[3];
        if(r1==0 && r2==0 && c1==0 && c2==0 && mat[0][0]!=0){
            al.add(new ArrayList<>());
            al.get(0).add(-1);
            return al;
        }
        for(int i = r1 ; i<=r2 ;i++){
            al.add(new ArrayList<>());
            for(int j = c1 ; j<=c2;j++){
                al.get(ii).add(mat[i][j]);
            }
            ii++;
        }
        return al;        
    }
}
