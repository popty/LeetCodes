class Solution {
    public int calculate(String s) {
        Queue<Character> tokens = new LinkedList<>();
        
        for(char c: s.toCharArray()){
            if(c!= ' ')tokens.offer(c);
        }
        
        tokens.offer('+');
        return calc(tokens);
    }
    
    private int calc(Queue<Character> tokens){
        char preop = '+';
        int last = 0, sum = 0, num = 0;
        while(!tokens.isEmpty()){
            char c = tokens.poll();
            while(!tokens.isEmpty() && c >='0' && c<='9'){
                num = num*10 + c - '0';
                c = tokens.poll();
            }
            
            if(c == '('){
                num = calc(tokens);
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
                
                
                preop = c;
                num = 0;
            }
        }
        return sum + last;
    }
}