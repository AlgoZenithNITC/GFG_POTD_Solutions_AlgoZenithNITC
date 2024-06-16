class Solution {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public static ArrayList<Integer> getPrimes(int n) {
        for (int a = 2; a <= n / 2; ++a) {
            int b = n - a;
            if (isPrime(a) && isPrime(b)) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(a);
                res.add(b);
                return res;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        return res;
    }
}
