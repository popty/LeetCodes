class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] prods = new int[m+n];
        
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                int multi = (int)(num1.charAt(i)-'0')*(int)(num2.charAt(j)-'0');
                int p1 = i+j, p2 = i+j+1;
                int sum = multi+prods[p2];
                
                prods[p1]+=sum/10;
                prods[p2] = sum%10;
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int prod: prods){
            if(!(sb.length()== 0 && prod == 0))sb.append(prod);
        }
        
        return sb.length()==0 ? "0" : sb.toString();
        
    }
}