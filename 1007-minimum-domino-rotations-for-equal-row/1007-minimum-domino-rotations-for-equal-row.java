class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topFreq = new int[7];
        int[] bottomFreq = new int[7];
        
        int maxTopFreq = 0;
        int maxBottomFreq = 0;
        
        int maxElemTop = 0;
        int maxElemBottom = 0;
        
        int ans = 0;
        
        for(int i = 0; i<tops.length; i++){
            
            topFreq[tops[i]]++;
            bottomFreq[bottoms[i]]++;
           
            if(topFreq[tops[i]] > maxTopFreq){
                maxTopFreq = topFreq[tops[i]];
                maxElemTop = tops[i];
            }
            
            if(bottomFreq[bottoms[i]] > maxBottomFreq){
                maxBottomFreq = bottomFreq[bottoms[i]];
                maxElemBottom = bottoms[i];
            }
        }
        
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