class Solution {
    public String getSmallestString(int n, int s) {
      if(n > s) return new String("Invalid Input"); 
      
      if(s > 26*n) return new String("Not Possible");
      
      char[] charArr = new char[n];
      
      int sum = n;
      
      int distance = s-n;
      
      for(int i = 0; i<n; i++){
          charArr[i] = 'a';
      }
      
      for(int i = n-1; i>=0; i--){
          
          if(distance == 0){
              return new String(charArr);
          }
          
          if(distance >= 26){
              charArr[i] = 'z';
              distance = distance+1 - 26;
          }
          
          else{
              //aaa 27  az = 28 , 2
              charArr[i] = (char)('a'+distance);
              distance = 0;
          }
      }
      
      return new String(charArr);
    }
}