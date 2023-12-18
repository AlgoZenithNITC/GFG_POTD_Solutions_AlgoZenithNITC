class Solution {
  public:
    int gameOfXor(int N , int A[]){
        if(N%2 == 0){
            return 0;
        }
        int final_xor = 0;
        for(int i = 0; i < N; i++){
            if(i%2 == 0){
                final_xor ^= A[i];
            }
        }
        return final_xor;
    }
};
