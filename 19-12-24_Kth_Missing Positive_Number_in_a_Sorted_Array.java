class Solution 
{
     public int kthMissing(int[] arr, int k) 
     {
        int lo = 0, hi = arr.length - 1;
        int miss = arr.length + k;

        while (lo <= hi) 
        {
            int mid = (lo + hi) / 2;
            if (arr[mid] > mid + k) 
            {
                miss = mid + k;
                hi = mid - 1;
            } 
            else 
            {
                lo = mid + 1;
            }
        }

        return miss;
    }
}