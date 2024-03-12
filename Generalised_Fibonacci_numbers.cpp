class Solution {
  public:
    vector<vector<long long>> multiply(vector<vector<long long>> &a, vector<vector<long long>> &b, long long m){
        vector<vector<long long>> mul (3, vector<long long>(3,0));
        for(int i =0; i<3; i++){
            for(int j =0; j<3; j++){
                for(int k =0; k<3; k++){
                    mul[i][j]= (mul[i][j] + a[i][k]*b[k][j])%m;
                }
            }
        }
        return mul;
    }
    
    vector<vector<long long>>  find(vector<vector<long long>> &arr, long long n, long long m){
        vector<vector<long long >> temp = {{1,0,0},{0,1,0},{0,0,1}};
        while(n>0){
            if(n&1){
                temp = multiply(temp, arr, m);
            }
            arr = multiply(arr, arr, m);
            n/=2;
        }
        return temp;
    }
    long long genFibNum(long long a, long long b, long long c, long long n, long long m) {
        // code here
        if(m == 1) return 0;
        if(n==1 or n==2) return 1; 
        vector<vector<long long>> F = {{a,b,1},{1,0,0},{0,0,1}};
        F = find(F, n-2, m);
        return (F[0][0] + F[0][1] + F[0][2]*c)%m;
    
    }
};
