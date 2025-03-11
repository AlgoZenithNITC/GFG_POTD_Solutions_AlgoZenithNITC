class GfG {
    static int countWays(int n) {
  
        if (n == 0 || n == 1)
            return 1;

        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }
}
