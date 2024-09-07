
class Solution {
    long findNth(long n) {

        if (n < 9) return n;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while (n >= 9) {
            int remainder = (int) (n % 9);
            temp.add(remainder);
            n /= 9;
            if (n < 9) {
                temp.add((int) n);
            }
        }
        
        long ans = 0;
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans = ans * 10 + temp.get(i);
        }
        
        return ans;
    }
}





