class Solution {
  public:
    long long max_Books(int arr[], int n, int k) {
        long long a=0;
        long long max_Books=0;
        for(int i=1;i<=n;i++){
            if(arr[i-1]<=k)
             a = a+arr[i-1];
            else
             a=0;
            max_Books=max(max_Books,a);
        }
        return max_Books;
    }
};
