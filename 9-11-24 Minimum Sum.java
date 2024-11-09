class Solution {
    // Function for finding sum of larger numbers
    public String findSum(String s1, String s2) {
        // Before proceeding further, make sure length
        // of str2 is larger.
        char[] str1, str2;
        if (s1.length() > s2.length()) {
            str1 = s2.toCharArray();
            str2 = s1.toCharArray();
        } else {
            str1 = s1.toCharArray();
            str2 = s2.toCharArray();
        }

        // Take an empty string for storing result
        StringBuilder str = new StringBuilder("");

        // Calculate length of both string
        int n1 = str1.length, n2 = str2.length;
        int diff = n2 - n1;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both strings
        for (int i = n1 - 1; i >= 0; i--) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((str1[i] - '0') + (str2[i + diff] - '0') + carry);
            str.append(sum % 10 + "");
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((str2[i] - '0') + carry);
            str.append(sum % 10 + "");
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0) str.append(carry + "");

        // reverse resultant string

        return str.reverse().toString();
    }

    public String minSum(int arr[]) {
        // sort the array
        int n = arr.length;
        Arrays.sort(arr);

        // let two numbers be a and b
        StringBuilder a = new StringBuilder(""), b = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && i != n - 1) continue;
            // fill a and b with every alternate digit
            // of input array
            if ((i & 1) == 1)
                a.append("" + arr[i]);
            else
                b.append("" + arr[i]);
        }

        // return the sum
        return findSum(a.toString(), b.toString());
    }
}
