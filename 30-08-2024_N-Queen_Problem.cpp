// Back-end complete function Template for C++

class Solution{
public:
    vector<vector<int>> result; // stores the final result
    int row[10], k = 0; // array to store the positions of queens
    
    // Function to check if it is safe to place a queen at position (r, c)
    bool place(int r,int c) {
    	for(int prev=0;prev<c;prev++)
    		if(row[prev]==r or abs(row[prev]-r)==abs(prev-c)) // condition to check if there is any queen already present in the same row or same diagonal
    			return false;
    	return true;
    }
    
    // Backtracking function to find all possible solutions
    void bt(int c,int n) {
    	if(n == 2 or n == 3) 
    	    return; // no solutions possible for n = 2 or n = 3
    	if(c == n) {
    		vector<int> v;
    		for(int i = 0;i < n;i++)
    		    v.push_back(row[i]+1); // storing the positions of queens in the current solution
    		result.push_back(v); // adding the current solution to the result vector
    		k++;
    	}
    	
    	for(int i = 0;i < n;i++) {
    		if(place(i, c)) {
    			row[c] = i; // placing the queen at position (i, c)
    			bt(c+1, n); // recursively solving for the next column
    		}
    	}
    }
    
    // Function to solve the N-Queen problem
    vector<vector<int>> nQueen(int n) {
        result.clear(); // clearing the result vector
        bt(0, n); // calling the backtracking function
        return result; // returning the result vector
    }
};
