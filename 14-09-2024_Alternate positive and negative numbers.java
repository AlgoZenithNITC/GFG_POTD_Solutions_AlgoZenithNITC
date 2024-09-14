class Solution {
    void rearrange(ArrayList<Integer> arr) {

        int n = arr.size();
        // create two ArrayLists to store negative and positive numbers separately
        ArrayList<Integer> neg = new ArrayList<Integer>();
        ArrayList<Integer> pos = new ArrayList<Integer>();

        // iterate through the array and add numbers to the appropriate ArrayList
        for (int i = 0; i < n; i++) {
            // if number is negative, add it to the neg ArrayList
            if (arr.get(i) < 0) {
                neg.add(arr.get(i));
            } // if number is positive, add it to the pos ArrayList
            else {
                pos.add(arr.get(i));
            }
        }

        int i = 0, j = 0, k = 0;
        // initialize variables for navigating through the neg and pos ArrayLists
        // rearrange the array by alternating between positive and negative numbers
        while (i < neg.size() && j < pos.size()) {
            arr.set(k++, pos.get(j++));
            arr.set(k++, neg.get(i++));
        }
        // add any remaining positive numbers to the array
        while (j < pos.size()) {
            arr.set(k++, pos.get(j++));
        }
        // add any remaining negative numbers to the array
        while (i < neg.size()) {
            arr.set(k++, neg.get(i++));
        }
    }
};
