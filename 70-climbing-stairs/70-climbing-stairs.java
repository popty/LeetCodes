class Solution {
    public int climbStairs(int n) {
        if(n <=2) return n;
        int ways1 = 1, ways2 = 2;
        int waysRes = 0;
        for(int i = 3; i<=n; i++){
            waysRes = ways1+ways2;
            ways1 = ways2;
            ways2 = waysRes;
        }
        
        return waysRes;
    }
}