class Solution{
    public:
    int findClosest( int n, int k,int arr[]) 
    { 
        if(k<=arr[0])
          return arr[0];
        if(k>= arr[n-1])
          return arr[n-1];
        
        int l=0,r=n-1,mid;
        while(l < r){
             mid = (l+r)/2;
            if(arr[mid]==k)
              return arr[mid];
            if(k < arr[mid]){
                if(mid>1 && k>arr[mid-1]){
                    if((k-arr[mid-1])<(arr[mid]-k) )
                      return arr[mid-1];
                    else
                      return arr[mid];
                }
                r = mid;
            }  
            else{
                if(mid<n-1 && k<arr[mid+1]){
                    if((k-arr[mid])<(arr[mid+1]-k) )
                      return arr[mid];
                    else
                      return arr[mid+1];
                }
                l = mid+1;
            }
        }
        return arr[mid];
    } 
};
