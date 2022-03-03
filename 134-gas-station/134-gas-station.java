class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_sum = 0;
        int sum = 0;
        int start = 0;
        
        for(int i = 0; i<gas.length; i++){
            sum+= gas[i]-cost[i];
            total_sum+=gas[i]-cost[i];
            if(sum < 0){
                start = i+1;
                sum = 0;
            }
        }
        
        return total_sum < 0 ? -1 : start;
    }
}