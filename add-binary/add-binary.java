class Solution {
    public String addBinary(String a, String b) {
        
        //111 11
        
        int m = a.length(), n = b.length();
        int len = Math.min(m, n);
        int carry = 0;
        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        StringBuilder sb3 = new StringBuilder();
        sb1.reverse();
        sb2.reverse();
        
        int i = 0;
        for( i = 0; i<len; i++){
            
            int a_ = sb1.charAt(i)-'0';
            int b_ = sb2.charAt(i)-'0';
            if(a_ == 1 && b_== 1){
                if(carry == 0)sb3.append(0);
                else sb3.append(1);
                carry = 1;
            }
            else if(a_ == 1 || b_ == 1){
                if(carry == 0){
                    sb3.append(1);
                    carry = 0;
                }
                else{
                    sb3.append(0);
                    carry = 1;
                }
            }
            
            else{
                if(carry == 0) sb3.append(0);
                else sb3.append(1);
                carry = 0;
            }
        }
        
        while(i<m){
            int a_ = sb1.charAt(i) - '0';
             if(a_ == 1 && carry == 1){
                sb3.append(0);
                carry = 1;
            }
            else if(a_ == 1 && carry == 0){
                sb3.append(1);
                carry = 0;
            }
            
            else if(a_ == 0 && carry == 1){
                sb3.append(1);
                carry = 0;
            }
            
            else{
                sb3.append(a_);
                carry = 0;
            }
            
            i++;
        }
        
        while(i<n){
            int a_ = sb2.charAt(i) - '0';
             if(a_ == 1 && carry == 1){
                sb3.append(0);
                carry = 1;
            }
            else if(a_ == 1 && carry == 0){
                sb3.append(1);
                carry = 0;
            }
            
            else if(a_ == 0 && carry == 1){
                sb3.append(1);
                carry = 0;
            }
            else{
                sb3.append(a_);
                carry = 0;
            }
            
            i++;
        }
        
        if(carry == 1)sb3.append(1);
        
        return sb3.reverse().toString();
        
        
    }
}