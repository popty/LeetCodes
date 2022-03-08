class Solution {
    public double average(int[] salary) {
        int max = 0, min = Integer.MAX_VALUE, sum = 0;
        for(int s: salary){
            max = Math.max(max, s);
            min = Math.min(min, s);
            sum+=s;
        }
        
        return (double)(sum-max-min)/(salary.length-2);
        
        
    }
}