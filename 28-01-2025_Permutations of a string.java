// Java program to print unique permutation of string using hash set.

import java.util.ArrayList;
import java.util.HashSet;

class GfG {
  
    // Function genPermutation is used to generate all possible permutation.
    static void genPermutation(int i, String s, boolean[] used, 
                                StringBuilder curr, HashSet<String> st) {
        if (i == s.length()) {
            // Add the permutation to the result set
            st.add(curr.toString());
            return;
        }

        for (int j = 0; j < s.length(); j++) {
            if (!used[j]) {
                // Mark the character as used
                used[j] = true;
                curr.append(s.charAt(j));
                
                // Recur with the next character
                genPermutation(i + 1, s, used, curr, st);
                
                // Backtrack and unmark the character
                used[j] = false;
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    static ArrayList<String> findPermutation(String s) {
      
        // To track if a character is used
        boolean[] used = new boolean[s.length()];
        HashSet<String> st = new HashSet<>();
        StringBuilder curr = new StringBuilder();

        // Start the recursion
        genPermutation(0, s, used, curr, st);

        // Convert the set to a list
        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        String s = "ABC";
        ArrayList<String> res = findPermutation(s);

        // Print the permutations
        for (String perm : res) {
            System.out.print(perm + " ");
        }
    }
}