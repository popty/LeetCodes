class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0; // it will give us a difference b/w gas & cost
        int surplus = 0; // our tank
        int start = 0; // and the index of gas station
        
        for(int i = 0; i < n; i++){
            total_surplus += gas[i]-cost[i];
            surplus+=gas[i]-cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i+1;
            }
        
        }
        return (total_surplus < 0) ? -1 : start;
       
    }
}