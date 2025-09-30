

class Solution {
    public void f(String str, List<String> result, int n) {
        if (str.length() == n) {
            result.add(str);
            return;
        }
        f(str + "0", result, n);
        f(str + "1", result, n);
    }

    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        f("", result, n);
        return result;
    }
}
