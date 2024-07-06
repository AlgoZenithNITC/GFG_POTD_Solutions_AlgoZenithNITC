class Solution {
    public int passThePillow(int n, int time) {
        int mod = 2 * (n - 1);
        time %= mod;
        if (time < n) {
            return time + 1;
        } else {
            time -= (n - 1);
            return n - time;
        }
    }
}
