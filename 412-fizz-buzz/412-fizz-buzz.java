class Solution {
    public List<String> fizzBuzz(int n) {
        String[] strArr = new String[n];
        for(int i = 1; i<=n; i++){
            strArr[i-1] = i+"";
        }
        
        for(int i = 2; i<n; i+=3){
            strArr[i] = "Fizz";
        }
        
        for(int i = 4; i<n; i+=5){
            strArr[i] = "Buzz";
        }
        
        for(int i = 14; i<n; i+=15){
            strArr[i] = "FizzBuzz";
        }
        
        return Arrays.asList(strArr);
    }
}