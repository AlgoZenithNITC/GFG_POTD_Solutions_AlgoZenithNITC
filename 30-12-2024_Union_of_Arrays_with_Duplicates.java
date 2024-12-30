class Solution {
    public static int findUnion(int a[], int b[]) {
        // code here
        // Using a HashSet to store unique elements
        HashSet<Integer> unionSet = new HashSet<>();
        
        // Add all elements from array a to the set
        for (int element : a) {
            unionSet.add(element);
        }
        
        // Add all elements from array b to the set
        for (int element : b) {
            unionSet.add(element);
        }
        
        // Return the size of the set as the count of distinct elements
        return unionSet.size();
    }
}
