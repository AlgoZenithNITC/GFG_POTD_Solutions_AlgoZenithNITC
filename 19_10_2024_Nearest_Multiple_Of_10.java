// User function Template for Java

class Solution {
    String roundToNearest(String str) {
        int n = str.length();
        if(str.charAt(n-1) <= '5'){
            return str.substring(0, n-1) + '0';
        } 
        int x = n-2;        
        while(x >= 0 && str.charAt(x) == '9'){
            x--;
        }        
        if(x < 0){
            StringBuilder ans = new StringBuilder();
            ans.append("1");
            for(int i = 0; i < n; i++){
                ans.append("0");
            }            
            return ans.toString();
        }       
        StringBuilder ans = new StringBuilder();
        if(x>0)
            ans.append(str.substring(0, x));        
        ans.append(String.valueOf(Integer.parseInt(String.valueOf(str.charAt(x))) + 1)); 
        x++;    
        while(x <= n-1){
            ans.append('0');
            x++;
        }     
        return ans.toString();
    }
}
