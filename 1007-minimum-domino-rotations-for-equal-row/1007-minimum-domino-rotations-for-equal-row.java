class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> topFreq = new HashMap<>();
        Map<Integer, Integer> bottomFreq = new HashMap<>();
        
        int maxTopFreq = 0;
        int maxBottomFreq = 0;
        
        int maxElemTop = 0;
        int maxElemBottom = 0;
        
        int ans = 0;
        
        for(int i = 0; i<tops.length; i++){
            int temp = topFreq.getOrDefault(tops[i], 0)+1;
            if(temp > maxTopFreq){
                maxTopFreq = temp;
                maxElemTop = tops[i];
            }
            topFreq.put(tops[i], temp);
            
            temp = bottomFreq.getOrDefault(bottoms[i], 0)+1;
            if(temp > maxBottomFreq){
                maxBottomFreq = temp;
                maxElemBottom = bottoms[i];
            }
            bottomFreq.put(bottoms[i], temp);
        }
        
        System.out.println(maxElemTop + "  "+ maxElemBottom);
         System.out.println(maxTopFreq + "  "+ maxBottomFreq);
        
        if(maxTopFreq > maxBottomFreq){
            for(int i = 0; i<tops.length; i+=1){
                if(tops[i] != maxElemTop &&
                   bottoms[i] != maxElemTop) return -1;
                
                else if(tops[i]!=maxElemTop) ans++;
            }
        }
        
        else{
            for(int i = 0; i<bottoms.length; i++){
                if(tops[i]!=maxElemBottom && bottoms[i]!=maxElemBottom) return -1;
                else if(bottoms[i] != maxElemBottom) ans++;
            }
        }
        
        return ans;
    }
}