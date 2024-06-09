
class Solution {
  public:
    void zigZag(int n, vector<int> &a) {
         bool f = true;
        
        for(int i=0;i<n-1;i++){
            if(i%2!=0)f=false;
            else f = true;
            
            if(f && a[i]>a[i+1] )swap(a[i],a[i+1]);
            
            if(!f && a[i]<a[i+1]) swap(a[i],a[i+1]);
            
            
           
        }
    }
};
