class Solution {
    public String getSmallestString(int n, int k) {
        if(n > k) return new String("Invalid Input");
        
        if(k > 26*n) return new String("Not Possible");
        
        char[] charArr = new char[n];
        
        Arrays.fill(charArr, 'a');
        
        int distance = k - n;
        
        for(int i = n-1; i>=0; i--){
            
            if(distance == 0)return new String(charArr);
            
            if(distance >= 26){
                charArr[i] = 'z';
                distance = distance - 26 + 1;
            }
            
            else{
                charArr[i] = (char)('a'+distance);
                distance = 0;
            }
        }
        
        return new String(charArr);
        
    }
}