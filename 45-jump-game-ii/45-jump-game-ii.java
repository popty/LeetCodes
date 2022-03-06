class Solution {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while(position != 0){
            for(int i = 0; i<nums.length; i++){
                if(nums[i]+i>= position){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}