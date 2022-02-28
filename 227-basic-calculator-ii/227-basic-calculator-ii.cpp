class Solution {
public:
    int calculate(string s) {
        int ans = 0;
        istringstream ss("+" + s);
        char op;
        int last;
        int n;
        while(ss >> op >> n){
            if(op == '+' || op == '-'){
                n = op == '+' ? n : -n;
                ans+=n;
            }else{
                n = op == '*' ? last*n : last/n;
                
                ans = ans - last + n;
            }
            
            last = n;
        }
        
        return ans;
    }
};