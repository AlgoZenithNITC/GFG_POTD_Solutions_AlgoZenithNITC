class Solution {
  public:
    int countFreq(vector<int>& arr, int target) 
    {  int n = arr.size();
       int start = 0;
       int end = n-1;
       
       
       int leftmost = -1;
       
       int rightmost =-1;
       
       
       while(start<=end)
       {
           int mid = (start+end)/2;
           
           if(arr[mid]>=target)
           {
               //we either we found out lower index or not
               //move high to check for lower possible or find the target
               
               leftmost = mid;
               end = mid-1;
               
           }
           
           else
            start = mid+1;
       }
       
       if(leftmost==-1 || arr[leftmost]!=target)
       {
           return 0;
       }
       
       start = 0;
       
       end = n-1;
       
         while(start<=end)
       {
           int mid = (start+end)/2;
           
           if(arr[mid]<=target)
           {
               //we either we found out upper index or not
               //move lo to check for higher possible or find the target
              
               rightmost = mid;
               start = mid+1;
               
           }
           
           else
            end = mid-1;
       }
       
       
        if(rightmost==-1 || arr[leftmost]!=target)
       {
           return 0;
       }
       
       return (rightmost-leftmost)+1;
     
    }  
    
    
};
