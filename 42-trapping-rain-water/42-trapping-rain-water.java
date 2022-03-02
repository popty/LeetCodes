class Solution {
    public int trap(int[] height) {
        int max_h = 0;
        int max_ind = 0;
        
        for(int i = 0; i<height.length; i++){
            if(max_h < height[i]){
                max_h = height[i];
                max_ind = i;
            }
        }
        
        int max_left = 0;
        int max_right = 0;
        int total_trapped = 0;
        
        
        for(int i = 0; i<max_ind; i++){
            if(max_left < height[i]){
                max_left = height[i];
            }    
            
            total_trapped+= max_left - height[i];
        }
        
        for(int i = height.length - 1; i>max_ind; i--){
           max_right = Math.max(max_right, height[i]);
            total_trapped += max_right - height[i];
        }
        
        return total_trapped;
    }
}