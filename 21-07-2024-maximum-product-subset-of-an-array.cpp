class Solution {
  public:
    long long int findMaxProduct(vector<int>& nums) {
        int size = nums.size();
        if (size == 1) {
            return nums[0];
        }

        long long int result = 1;
        int mod = 1e9 + 7;
        int minNegIndex = -1, minNegValue = 0;
        int zeroCount = 0, negCount = 0;

        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] < 0) {
                negCount++;
                if (minNegIndex == -1 || nums[i] > minNegValue) {
                    minNegIndex = i;
                    minNegValue = nums[i];
                }
            }
        }

        if (zeroCount == size) {
            return 0;
        }

        if (negCount == 1 && zeroCount == size - 1) {
            return 0;
        }

        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (negCount % 2 == 1 && i == minNegIndex) {
                continue;
            }
            result = ((result * nums[i]) % mod + mod) % mod;
        }
        return result;
    }
};
