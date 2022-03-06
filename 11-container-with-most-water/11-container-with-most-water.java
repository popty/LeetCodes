class Solution {
    public int maxArea(int[] height) {
        
        int start = 0, end = height.length-1;
        int max_water =  0;
        int max_left = 0;
        int max_right = end;
        while(start < end){
            max_water = Math.max(max_water, (end-start)*Math.min(height[start], height[end]));
            
            if(height[start] < height[end])
                start++;
            else
                end--;
        }
        
      
        return max_water;
        
    }
}