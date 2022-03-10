class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c != ' ')queue.offer(c);
        }
        
        queue.offer('+');
        
        char preop = '+';
        
        int last = 0, num = 0;
        
        int sum = 0;
        
        while(!queue.isEmpty()){
            char c = queue.poll();
            while(!queue.isEmpty() && (c>='0' &&  c<='9')){
                num = num*10+c-'0';
                c = queue.poll();
            }
            
            switch(preop){
                case '+':
                    sum = sum+last;
                    last = num;
                    break;
                case '-':
                    sum = sum+last;
                    last = -num;
                    break;
                case '*':
                    last*=num;
                    break;
                case '/':
                    last/=num;
                    break;
            }
            preop = c;
            num = 0;
        }
        
        return last+sum;
        
    }
}