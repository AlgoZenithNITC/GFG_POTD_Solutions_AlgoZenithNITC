void rotate(vector<vector<int> >& matrix) {
    int m=matrix.size();
    //int n=sizeof(matrix[0]);
    for(int i=0;i<m;i++){
        for(int j=i;j<m;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
   for(int i=0;i<m;i++){
       for(int j=0;j<m/2;j++){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[i][m-j-1];
        matrix[i][m-j-1]=temp;}
    }
     
   // return matrix;
}
