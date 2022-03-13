/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int ans = n < Integer.MAX_VALUE ? n+1 : n;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(isBadVersion(mid)){
                ans = Math.min(mid, ans);
                hi = mid-1;
            }
            else lo = mid+1;
        }
        
        if(isBadVersion(lo)) return ans = Math.min(ans, lo);
        
        return ans;
    }
}