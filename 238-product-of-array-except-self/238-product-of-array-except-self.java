class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i = 1; i<n; i++){
            result[i] = result[i-1]*nums[i-1];
        }
        
        int prod_right = nums[n-1];
        for(int i = n-2; i>=0; i--){
            result[i] = result[i]*prod_right;
            prod_right*=nums[i];
        }
        
        
        return result;
    }
}