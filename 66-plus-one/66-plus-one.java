class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        int carry = 1;
        for(int i = digits.length; i>=1; i--){
            res[i] = (digits[i-1]+carry)%10;
            carry = (digits[i-1]+carry)/10;
        }
        
        if(carry != 0){
            res[0] = 1;
            return res;
        }
        
        return Arrays.copyOfRange(res, 1, digits.length+1);
    }
}