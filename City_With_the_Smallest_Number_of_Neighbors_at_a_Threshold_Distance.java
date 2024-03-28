

// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int [][]mat= new int[n][n];
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  if(j==i){
                      mat[i][j]=0;
                  }else{
                      mat[i][j] = (int)1e9;
                  }
              }
          }
          for(int i=0;i<m;i++){
              int r = edges[i][0];
              int c = edges[i][1];
              int w = edges[i][2];
              mat[r][c] = w;
              mat[c][r] = w;
          }
          
          for(int k=0;k<n;k++){
              for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                      mat[i][j] = (int)Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                  }
              }
          }
          int min_city = (int)1e9;
          int city = (int)1e9;
          for(int i=0;i<n;i++){
              int c = 0;
              for(int j=0;j<n;j++){
                  if(mat[i][j]>0 && mat[i][j]<=distanceThreshold){
                      c = c+1;
                  }
              }
              if(c<=min_city){
                  min_city = c;
                  city = i;
              }
          }
          return city;
      }
}
