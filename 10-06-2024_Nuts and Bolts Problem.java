//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java


        // code here
        

class Solution {
    public void matchPairs(int n, char[] nuts, char[] bolts) {
        // Map characters to numbers for sorting
      
        for (int i = 0; i < n; i++) {
            nuts[i] = mapCharToNum(nuts[i]);
            bolts[i] = mapCharToNum(bolts[i]);
        }

        // Sort the mapped characters
        Arrays.sort(nuts);
        Arrays.sort(bolts);

        // Map numbers back to characters
        for (int i = 0; i < n; i++) {
            nuts[i] = mapNumToChar(nuts[i]);
            bolts[i] = mapNumToChar(bolts[i]);
        }
    }

    private char mapCharToNum(char c) {
        switch (c) {
            case '!': return '0';
            case '#': return '1';
            case '$': return '2';
            case '%': return '3';
            case '&': return '4';
            case '*': return '5';
            case '?': return '6';
            case '@': return '7';
            case '^': return '8';
            default: return c; // should not reach here
        }
    }

    private char mapNumToChar(char c) {
        switch (c) {
            case '0': return '!';
            case '1': return '#';
            case '2': return '$';
            case '3': return '%';
            case '4': return '&';
            case '5': return '*';
            case '6': return '?';
            case '7': return '@';
            case '8': return '^';
            default: return c; // should not reach here
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] nuts = {'$', '%', '@', '#', '*'};
        char[] bolts = {'%', '@', '#', '*', '$'};

        solution.matchPairs(nuts.length, nuts, bolts);

        System.out.println("Nuts: " + Arrays.toString(nuts));
        System.out.println("Bolts: " + Arrays.toString(bolts));
    }
}