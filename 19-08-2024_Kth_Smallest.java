class Solution{
    
    void show(int[] arr, int i, int n) {
        int l = i * 2 + 1; 
        int r = i * 2 + 2;
        int max = i;
        int t;

        if (r < n) {
            if (arr[l] > arr[r]) {
                max = l;
            } else {
                max = r;
            }
        } else if (l < n) {
            max = l;
        }

        if (arr[max] > arr[i]) {
            t = arr[i];
            arr[i] = arr[max];
            arr[max] = t;
            show(arr, max, n);
        }
    }
     
    public int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        for (int i = (r + 1) / 2 - 1; i >= 0; i--) {
            show(arr, i, r + 1);
        }

        int t;
        for (int i = r; i >= k; i--) {
            t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;
            show(arr, 0, i);
        }

        return arr[0];
    } 
}
