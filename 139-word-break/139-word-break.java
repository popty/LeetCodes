class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        Queue<Integer> bfs = new LinkedList<>();
        Set<String> dictSet = new HashSet<>(wordDict);
        bfs.add(0);
        boolean[] visited = new boolean[s.length()];
        while(!bfs.isEmpty()){
            int node = bfs.poll();
            
            if(visited[node]) continue;
            
            visited[node] = true;
            
            for(int i = node+1; i<=s.length(); i++){
               
                if(dictSet.contains(s.substring(node, i))){
                    bfs.offer(i);
                    if(i == s.length()) return true;
                }
            }
        }
        
        return false;
        
    }
}