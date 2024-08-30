class Solution:
    def place(self,r,c):  # Function to check if it is possible to place a queen at position (r, c)
        for prev in range(c):  # Loop through all previous columns
            if self.row[prev]==r or abs(self.row[prev]-r) ==abs(prev-c) :  # Check if the queen in the previous column conflicts with the current position
                return False  # Return False if there is a conflict
        return True  # Return True if there is no conflict

    def bt(self,c,n):  # Backtracking function to find all possible solutions
        if n==2 or n==3 :  # If n is 2 or 3, there are no possible solutions
            return
        if c==n :  # If we have placed all n queens, add the current configuration to the result list
            v = []
            for i in range(n):
                v.append(self.row[i]+1)  # Add the row number of the queen at each column to the result list
            self.result.append(v)  # Add the current configuration to the result list
            self.k+=1  # Increment the count of solutions

        for i in range(n):  # Loop through all possible rows for the current column
            if (self.place(i,c)) :  # Check if it is possible to place a queen at position (i, c)
                self.row[c]=i  # Place the queen at position (i, c)
                self.bt(c+1,n)  # Recursively call the backtracking function for the next column

    def nQueen(self, n):  # Function to find all possible solutions for the N-Queen problem
        self.result = []  # List to store all possible solutions
        self.row = [0]*10  # List to store the row number of the queen at each column
        self.k = 0  # Count of solutions

        self.bt(0,n)  # Call the backtracking function to find all possible solutions starting from the first column
        return self.result  # Return the list of all possible solutions
