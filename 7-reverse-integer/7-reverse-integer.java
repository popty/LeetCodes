class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        
        x = Math.abs(x);
        
        
        int num = 0;
        
        while(x!=0){
            int temp = x%10;
            x/=10;
            //10*num +temp < Integer.MAX_VALUE
            if(num > (Integer.MAX_VALUE-temp)/10)return 0;
            
            num = 10*num + temp;
            
        }
        
        return sign*num;
    }
}