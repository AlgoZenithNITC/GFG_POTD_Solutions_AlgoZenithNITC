class Solution{
    public:
    // arr : given array
    // l : starting index of the array i.e 0
    // r : ending index of the array i.e size-1
    // k : find kth smallest element and return using this function
 //Using Max Heap Sort
void show(int arr[],int i,int n)
{
  int l=i*2+1; 
  int r=i*2+2;
  int t;
  int max=i;
  if(r<n)
  {
      if(arr[l]>arr[r])
      {
        max=l;  
      }
      else
      {
          max=r;
      }
  }
  else if(l<n)
  {
      max=l;
  }
  if(arr[max]>arr[i])
  {
      t=arr[i];
      arr[i]=arr[max];
      arr[max]=t;
      show(arr,max,n);
  }
}

int kthSmallest(int arr[], int l, int r, int k)
{
    for(int i=r+1/2-1;i>=0;i--)
    {
        show(arr,i,r+1);
    }
           int t;
    for(int i=r;i>=k;i--)
    {
       t=arr[0];
       arr[0]=arr[i];
       arr[i]=t;
       show(arr,0,i);
    }
return arr[0];
}
};
