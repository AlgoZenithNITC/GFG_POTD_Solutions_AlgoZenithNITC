//Back-end complete function template for C++

class Solution {
  public:
    // Function to assign bracket numbers to each parenthesis in a string.
    vector<int> bracketNumbers(string str) {
        string temp = str;
        vector<int> ans; // vector to store the bracket numbers
        stack<int> st;   // stack to store the opening bracket numbers

        int bal = 0; // variable to keep track of current bracket number

        // iterating over the string
        for (int i = 0; i < temp.size(); i++) {
            // if opening bracket is encountered
            if (temp[i] == '(') {
                // incrementing the bracket number
                bal++;

                // adding the bracket number to the result vector and stack
                ans.push_back(bal);
                st.push(bal);
            }
            // if closing bracket is encountered
            else if (temp[i] == ')') {
                // adding the top bracket number from the stack to the result vector
                ans.push_back(st.top());
                st.pop();
            }
        }

        return ans; // returning the result vector with assigned bracket numbers
    }
};
