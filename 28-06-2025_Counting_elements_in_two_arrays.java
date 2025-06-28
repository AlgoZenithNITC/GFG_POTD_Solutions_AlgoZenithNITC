class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here

        int maxVal = 0;
        for (int num : a) maxVal = Math.max(maxVal, num);
        for (int num : b) maxVal = Math.max(maxVal, num);

        int[] freq = new int[maxVal + 2]; // Step 1: Frequency array

        // Step 2: Count frequencies in b[]
        for (int num : b) {
            freq[num]++;
        }

        // Step 3: Build prefix sum
        for (int i = 1; i <= maxVal + 1; i++) {
            freq[i] += freq[i - 1];
        }

        // Step 4: Prepare result
        ArrayList<Integer> result = new ArrayList<>();
        for (int value : a) {
            result.add(freq[value]);
        }

        return result;
    }       
        
}
