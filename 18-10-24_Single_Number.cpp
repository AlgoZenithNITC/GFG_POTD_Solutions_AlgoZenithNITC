class Solution {
  public:
    // Function to find the element in the array which occurs only once.
    int getSingle(vector<int>& arr) {
        // variable to store the XOR of all elements in the array.
       int n = arr.size();
       unordered_map<int, int> hash;
    
        // Putting all elements into the HashMap 
        for(int i = 0; i < n; i++)
        {
            hash[arr[i]]++;
        }
        // Iterate through HashMap to check an element
        // occurring odd number of times and return it
        for(auto i : hash)
        {
            if(i.second % 2 != 0)
            {
                return i.first;
            }
        }
        return -1;
    
    }
};
