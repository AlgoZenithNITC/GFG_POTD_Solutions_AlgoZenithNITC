//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j <= i; j++) {
                    ansList.add(mat[j][i - j]);
                }
            } else {
                for (int j = i; j >= 0; j--) {
                    ansList.add(mat[j][i - j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if ((i % 2) != (n % 2)) {
                for (int j = n - i - 1; j >= 0; j--) {
                    ansList.add(mat[i + j][n - 1 - j]);
                }
            } else {
                for (int j = 0; j < n - i; j++) {
                    ansList.add(mat[i + j][n - 1 - j]);
                }
            }
        }

        int[] ansArray = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;
    }
}