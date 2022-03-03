class Solution {
    public int calculate(String s) {
        Queue<Character> tokens = new LinkedList<>();
        
        for(char c: s.toCharArray()){
            if(c!=' ')tokens.add(c);
        }
        tokens.offer('+');
        return calculate(tokens);
        
    }
    
    private int calculate(Queue<Character> tokens){
        
        int last = 0, num = 0, sum = 0;
        char preop = '+';
        
        while(!tokens.isEmpty()){
            
            char c = tokens.poll();
            
            while(!tokens.isEmpty() && c>='0' && c<='9'){
                num = num*10 + c - '0';
                c = tokens.poll();
            }
            
            if(c == '('){
                num = calculate(tokens);
            }
            
            
            
            else{
                switch(preop){
                    case '+':
                        sum = sum+last;
                        last = num;
                        break;
                    case '-':
                        sum = sum+last;
                        last = -num;
                        break;
                }
                
                if(c == ')') break;
                
                num = 0;
                preop = c;
            }
        }
        
        return sum+last;
    }
}