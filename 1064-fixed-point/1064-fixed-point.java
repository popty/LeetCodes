class Solution {
    public int fixedPoint(int[] arr) {
        int lo = 0, hi = arr.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]-mid<0)lo = mid+1;
            else hi = mid;
        }
        
       
        
       return lo == arr[lo] ? lo : -1;
    }
}