class Solution 
{

    public static int countgroup(int arr[])
    {
        
        int totalXor = arr[0];
        int n = arr.length;
        
        for (int i = 1; i < n; i++) 
        {
            totalXor = totalXor ^ arr[i];
        }
        
        if (totalXor != 0) 
        {
            return 0;
        }
        
        return (1 << (n - 1)) - 1;
        
    }
}