class Solution {
    public int minOperations(int[] arr) {
        // code here
        double sum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Build the max-heap and compute total sum
        for (int x : arr) {
            sum += x;
            maxHeap.add((double) x);
        }

        double target = sum / 2.0;
        double curr = sum;
        int count = 0;

        // Keep halving the largest element until total <= half of original sum
        while (curr > target) {
            double largest = maxHeap.poll();  // remove the largest element
            double half = largest / 2.0;
            curr -= half;                      // decrease current sum
            maxHeap.add(half);                 // push back the halved value
            count++;
    }
    return count;
}

}
