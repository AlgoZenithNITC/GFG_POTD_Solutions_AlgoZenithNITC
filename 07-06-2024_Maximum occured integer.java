//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
class Solution {
    public int maxOccured(int n, int[] l, int[] r, int maxx) {
        // Initialize array with size maxx + 2
        int[] arr = new int[maxx + 2];
        
        // Apply the logic to process the ranges
        for (int i = 0; i < n; i++) {
            arr[l[i]]++;
            arr[r[i] + 1]--;
        }
        
        // Compute the prefix sum array
        int sum = 0;
        for (int i = 0; i <= maxx; i++) {
            arr[i] += sum;
            sum = arr[i];
        }
        
        // Find the index of the maximum element in the prefix sum array
        int ans = 0;
        for (int i = 1; i <= maxx; i++) {
            if (arr[i] > arr[ans]) {
                ans = i;
            }
        }
        
        return ans;
    }
};




//{ Driver Code Starts.

// } Driver Code Ends