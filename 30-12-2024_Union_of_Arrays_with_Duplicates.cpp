class Solution {
  public:
    // Function to return the count of number of elements in union of two arrays.
    int findUnion(vector<int>& a, vector<int>& b) {
        // code here
        set<int> unionSet;
        
        // Insert all elements from array a
        for (int element : a) {
            unionSet.insert(element);
        }
        
        // Insert all elements from array b
        for (int element : b) {
            unionSet.insert(element);
        }
        
        // Return the size of the set as the count of distinct elements
        return unionSet.size();
    }
};
