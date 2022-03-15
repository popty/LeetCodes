class Solution {
    public String minRemoveToMakeValid(String s) {
        int countOpen = 0;
        int countClosed = 0;
        int remove = 0;
        
        StringBuilder result = new StringBuilder();
        
        for(char c: s.toCharArray()){
           if(c == ')') countClosed++;
           if(countClosed > countOpen){
               countClosed--;
               continue;
           }
           if(c == '(') countOpen++;
           result.append(c);
            
        }
        
        s = result.toString();
        countClosed = 0;
        countOpen = 0;
        result = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == ')')countClosed++;
            if(c == '(')countOpen++;
            if(countOpen > countClosed){
                countOpen--;
                continue;
            }
            result.append(c);
        }
        
        return result.reverse().toString();
        
        
    }
}