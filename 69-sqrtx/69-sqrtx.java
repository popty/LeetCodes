class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;        
        
        long lo = 0, hi = x/2;
        long mid;
        long res = 0;
        while(lo<hi){
            
            mid = lo+(hi-lo)/2;
            
            if(mid*mid == x)return (int)mid;
            
            if(mid*mid > x ){
                hi = mid-1;
            }
            else if(mid*mid<x){
                res = mid;
                lo = mid+1;
            }
        }
        
        if(lo*lo <= x)return (int)lo;
        
        return (int)res;
    }
}