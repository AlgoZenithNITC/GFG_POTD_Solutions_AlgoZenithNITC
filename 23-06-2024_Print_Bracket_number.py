# from typing import List


class Solution:

    def bracketNumbers(self, str):
        ans = []  # List to store the bracket numbers
        st = []  # Stack to store the opening bracket numbers

        bal = 0  # Variable to keep track of current bracket number

        # Iterating over the string
        for i in range(len(str)):
            # If opening bracket is encountered
            if str[i] == '(':
                # Incrementing the bracket number
                bal += 1

                # Adding the bracket number to the result list and stack
                ans.append(bal)
                st.append(bal)
            # If closing bracket is encountered
            elif str[i] == ')':
                # Adding the top bracket number from the stack to the result list
                ans.append(st.pop())

        return ans  # Returning the result list with assigned bracket numbers
