class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        int n = nums.size();
        int num1 = 0, num2 = 0, c1 = 0, c2 = 0;
        List<Integer> res = new ArrayList<>();

        // Finding the two most frequent numbers using Boyer-Moore algorithm
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = x;
                c1 = 1;
            } else if (c2 == 0) {
                num2 = x;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        // Counting the occurrences of num1 and num2
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            }
        }

        // Checking if num1 and num2 are majority elements
        if (c1 > n / 3) res.add(num1);
        if (c2 > n / 3) res.add(num2);
        Collections.sort(res);
        // If no majority elements, add -1 to the result list
        if (res.isEmpty()) res.add(-1);
        return res;
    }
}
