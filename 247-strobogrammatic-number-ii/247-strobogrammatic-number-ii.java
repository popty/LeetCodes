class Solution {
    
    List<String> onesList = Arrays.asList("0", "1", "8");
    List<String> evenList = Arrays.asList("00", "11", "69", "88", "96");
    
    
    public List<String> findStrobogrammatic(int n) {
        List<String> numbers = new ArrayList<>();
        if(n >= 2){
           numbers = Arrays.asList("11", "69", "88", "96");
           n-=2;
        }
        
        else if(n == 1){
            numbers = Arrays.asList("0","1","8");
            return numbers;
        }
        
        Queue<String> bfs = new LinkedList<>(numbers);
        
        while(n>0){
            numbers = new ArrayList<>();
            if(n>=2){
                while(!bfs.isEmpty()){
                    String node = bfs.poll();
                    int len = node.length();
                    for(String even: evenList){
                        String child = 
                            node.substring(0, len/2) + even + node.substring(len/2);
                        numbers.add(child);
                    }  
                }
                bfs = new LinkedList<>(numbers);
                n-=2;
            }
                else{
                    while(!bfs.isEmpty()){
                    String node = bfs.poll();
                    int len = node.length();
                    for(String ones: onesList){
                        String child = 
                            node.substring(0, len/2) + ones + node.substring(len/2);
                        numbers.add(child);
                    }  
                }
                bfs = new LinkedList<>(numbers);
                n-=1;
                }
            }
        
        return numbers;
    }
}