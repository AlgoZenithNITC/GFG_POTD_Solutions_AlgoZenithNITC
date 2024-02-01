class Solution
{
    int atoi(String s) {
	// Your code here
	   int n = s.length(), sum = 0, k = 1;
        for (int i = n - 1; i >= 1; i--) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int temp = s.charAt(i) - '0';
                sum += (k * temp);
                k *= 10;
            } else {
                return -1;
            }
        }
        if (s.charAt(0) == '+') {
            return sum;
        } else if (s.charAt(0) == '-') {
            return (0 - sum);
        } else if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            int temp = s.charAt(0) - '0';
            sum += (k * temp);
            return sum;
        } else {
            return -1;
        }
    }
}
