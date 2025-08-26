import java.io.*;

class GfG {
    static boolean isSubSequence(String s1, String s2,
                                 int m, int n){
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        // If last characters of two strings are matching
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return isSubSequence(s1, s2, m - 1, n - 1);

        // If last characters are not matching
        return isSubSequence(s1, s2, m, n - 1);
    }

    public static void main(String[] args){
        String s1 = "gksrek";
        String s2 = "geeksforgeeks";
        int m = s1.length();
        int n = s2.length();
        boolean res = isSubSequence(s1, s2, m, n);
        if (res)
            System.out.println("true");
        else
            System.out.println("false");
    }
}