class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int index = s.length() - 1;
        int res = 0;
        char prev = ' ';
        
        while(index > -1){
            char c = s.charAt(index);
            if(prev == ' '){
                res+=map.get(c);
                prev = c;
                index--;
                continue;
            }
            
            else if(prev == 'V' || prev == 'X'){
                if(c == 'I')res-=1;
                else res+=map.get(c);
            }
            
            else if(prev == 'L' || prev == 'C'){
                if(c == 'X')res-=10;
                else res+=map.get(c);
            }
            
            else if(prev == 'D' || prev == 'M'){
                if(c == 'C')res-=100;
                else res+=map.get(c);
            }
            
            else{
                res+=map.get(c);
            }
            
            prev = c;
            index--;
        }
        
        return res;
        
    }
}