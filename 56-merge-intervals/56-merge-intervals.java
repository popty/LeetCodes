class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        int[][] result = new int[intervals.length][2];
        
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        int j  =0;
        
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] <= result[j][1]){
                result[j][1] = Math.max(result[j][1], intervals[i][1]);
            }
            else{
                ++j;
                result[j][0] = intervals[i][0];
                result[j][1] = intervals[i][1];
            }
            
        }
        
       return Arrays.copyOfRange(result, 0, j+1);
    }
}