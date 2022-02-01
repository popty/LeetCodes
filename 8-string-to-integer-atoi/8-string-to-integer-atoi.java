class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        
        if(s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        while(index < s.length()){
            
           
            
            int digit = s.charAt(index) - '0';
            
            if(digit < 0 || digit > 9) break;
            
            if(Integer.MAX_VALUE/10 < total ||
               (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 
            
            total = 10*total + digit;
            index++;
        }
        
        return sign*total;
        
    }
}