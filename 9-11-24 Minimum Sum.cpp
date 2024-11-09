class Solution {
  public:
    // Function for finding sum of larger numbers
    string findSum(string str1, string str2) {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length())
            swap(str1, str2);

        // Take an empty string for storing result
        string str = "";

        // Calculate length of both string
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both strings
        for (int i = n1 - 1; i >= 0; i--) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((str1[i] - '0') + (str2[i + diff] - '0') + carry);
            str.push_back(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((str2[i] - '0') + carry);
            str.push_back(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry)
            str.push_back(carry + '0');

        // reverse resultant string
        reverse(str.begin(), str.end());

        return str;
    }

    string minSum(vector<int> &arr) {
        int n = arr.size();
        // sort the array
        sort(arr.begin(), arr.end());

        // let two numbers be a and b
        string a, b;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && i != n - 1)
                continue;
            // fill a and b with every alternate digit
            // of input array
            if (i & 1)
                a += (char)(arr[i] + '0');
            else
                b += (char)(arr[i] + '0');
        }

        // return the sum
        return findSum(a, b);
    }
};
