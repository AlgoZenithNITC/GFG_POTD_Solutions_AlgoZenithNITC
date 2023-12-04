class Solution{
     public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder output = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            if(i >= 0){
                sum += num1.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += num2.charAt(j--) - '0';
            }
            int rem = sum % 10;
            carry = sum / 10;
            output.append(rem);
        }
        return output.reverse().toString();
    }

    public boolean check(String str, int start, int len1, int len2, int n){
        String s1 = str.substring(start, start + len1);
        String s2 = str.substring(start + len1, start + len1 + len2);
        String s3 = addStrings(s1, s2);
        int s3_len = s3.length();
        if(s3_len > n - len1 - len2 - start){
            return false;
        }
        if(s3.equals(str.substring(start + len1 + len2, start + len1 + len2 + s3_len))){
            if(start + len1 + len2 + s3_len == n){
                return true;
            }
            return check(str, start + len1, len2, s3_len, n);
        }
        return false;
    }
    public int isSumString(String str){
        int n = str.length();
        for(int i = 1; i < n; i++){
            for(int j = 1; i + j < n; j++){
                if(check(str, 0, i, j, n)){
                    return 1;
                }
            }
        }
        return 0;
    }
}
