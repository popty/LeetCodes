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
        
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'I'){
                if(i!=s.length()-1 && s.charAt(i+1) == 'V'){
                    res+=4;
                    i++;
                    continue;
                }
                if(i!=s.length()-1 && s.charAt(i+1) == 'X'){
                    res+=9;
                    i++;
                    continue;
                }
                else{
                    res+=map.get('I');
                }
            }
            
            else if(c == 'X'){
                if(i!= s.length()-1 && s.charAt(i+1) == 'L'){
                    res+=40;
                    i++;
                    continue;
                }
                if(i!= s.length()-1 && s.charAt(i+1) == 'C'){
                    res+=90;
                    i++;
                    continue;
                }else{
                    res+=map.get('X');
                }
            }
            
            else if(c == 'C'){
                if(i!=s.length()-1 && s.charAt(i+1) == 'D'){
                    res+=400;
                    i++;
                    continue;
                }
                if(i!=s.length()-1 && s.charAt(i+1) == 'M'){
                    res+=900;
                    i++;
                    continue;
                }else{
                    res+=map.get('C');
                }
            }
            
            else{
                res+=map.get(c);
            }
        }
        
        return res;
    }
}