class Solution {
    
    int[] nums;
    public int binary(int lo, int key, int hi){
        int mid;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            if(nums[mid] == key) return mid;
            else if(nums[mid] > key) hi = mid-1;
            else lo = mid+1;
        }
        
        return -1;
    }
    
    
    public List<List<Integer>> threeSum(int[] nums) {
      
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        
        for(int i = 0; i<len-2; i++){
            int a = nums[i];
            for(int j = i+1; j<len-1; j++){
                int b = nums[j];
                int target = -a-b;
                int k = binary(j+1, target, len-1);
                if(k != -1){
                    List<Integer> result_temp = new ArrayList<>();
                    result_temp.add(a);
                    result_temp.add(b);
                    result_temp.add(nums[k]);
                    if(!set.contains(result_temp))
                        {
                         result.add(result_temp);
                         set.add(result_temp);
                        }
                }
            }
        }
        
        return result;
    }
}