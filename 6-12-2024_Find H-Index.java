class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
         Arrays.sort(citations);
        
        int n = citations.length;
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int papersWithAtLeastCitations = n - i;
            if (citations[i] >= papersWithAtLeastCitations) {
                hIndex = papersWithAtLeastCitations;
                break;
            }
        }
        
        return hIndex;
    }
}