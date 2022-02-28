class Solution {
 public int calculate(String s) {
   Queue<Character> tokens = new ArrayDeque<Character>();

   for(char c : s.toCharArray()){
       if(c != ' ') tokens.offer(c);
   }

   tokens.offer('+');
   return calculate(tokens);
}

private int calculate(Queue<Character> tokens){

   char preOp = '+';
   int num = 0, sum = 0, prev = 0;

   while(!tokens.isEmpty()){
        char c = tokens.poll();

       while(!tokens.isEmpty() && '0' <= c && c <= '9') {
            num = num * 10 + c - '0';
            c = tokens.poll();
        } if(c=='(') {
            num = calculate(tokens);
        }else{
            switch (preOp){
                case '+':
                    sum += prev;
                    prev = num;
                    break;
                case '-':
                    sum += prev;
                    prev = -num;
                    break;
                case '*':
                    prev *= num;
                    break;
                case '/':
                    prev /= num;
                    break;
            }

            if(c == ')')
                break;

            preOp = c;
            num = 0;
        }
   }

   return sum + prev;
}
}