class Solution{
    public:
    long long int sumXOR(int arr[], int n){
        long long sum = 0;
        for(int bit = 0; bit < 32; bit++){
            long long int set_bits = 0, unset_bits = 0;
            for(int j = 0; j < n; j++){
                if((arr[j]&(1 << bit)) != 0){
                    set_bits++;
                }else{
                    unset_bits++;
                }
            }
            long long possible_combinations = (set_bits)*(unset_bits);
            sum += possible_combinations*(1 << bit);
        }
        return sum;
    }
};
