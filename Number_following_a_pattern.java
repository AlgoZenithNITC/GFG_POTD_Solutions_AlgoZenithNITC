    static String printMinNumberForPattern(String s){
        int n = s.length(), current = 1, i = 0;
        StringBuilder ans = new StringBuilder();
        ans.append('1');
        while(i < n){
            if(s.charAt(i) == 'D'){
                int j = i;
                while(j < n && s.charAt(j) == 'D'){
                    j++;
                }
                int no_of_D = j - i;
                current += no_of_D;
                ans.setCharAt(i, (char)((int)('0') + current));
                int count = current;
                while(i != j){
                    count--;
                    ans.append(count);
                    i++;
                }
            }else{
                current++;
                ans.append(current);
                i++;
            }
        }
        return ans.toString();
    }
}
