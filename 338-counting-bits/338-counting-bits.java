class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n+1];
       for(int N = 0; N<=n; N++){
            for(int i = 0; i<32; i++){
                if(((N>>i) & 1 )> 0)count[N]++;
            }
       }
        return count;        
    }
}