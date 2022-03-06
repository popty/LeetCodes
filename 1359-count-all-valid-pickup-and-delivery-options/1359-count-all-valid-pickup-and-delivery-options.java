class Solution {
    public int countOrders(int n) {
        long ans = 1;
        int MOD = 1_000_000_007;
        for(int i = 1; i<=n; i++){
            ans = (ans * i)%MOD;
            ans = (ans%MOD * (2*i - 1)%MOD)%MOD;
        }
        
        return (int)ans;
    }
}