class Solution {
    int rectanglesInCircle(int r) {
          int count = 0;
        int diameterSquared = 4 * r * r;
        for (int w = 1; w <= 2 * r; w++) {
            for (int h = 1; h <= 2 * r; h++) {
                if (w * w + h * h <= diameterSquared) {
                    count++;
                }
            }
        }
        
        return count;
    }
};
