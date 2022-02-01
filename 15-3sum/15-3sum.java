class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i<n-1; i++){
            if(i==0 || nums[i] != nums[i-1]){
                int lo = i+1, hi = n-1;
                int sum = 0-nums[i];
                
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1])lo++;
                        while(lo<hi && nums[hi] == nums[hi-1])hi--;
                        lo++;
                        hi--;
                    }
                    
                    else if(nums[lo] + nums[hi] > sum) hi--;
                    
                    else lo++;
                }
                
            }
        }
        
        return list;
    }
}