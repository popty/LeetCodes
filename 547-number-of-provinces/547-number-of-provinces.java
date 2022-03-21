class Solution {
    
    private void dfs(int[][] isConnected, boolean[] visited, int i){
        for(int j = 0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
        return;
    }
    
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int ans = 0;
        for(int i = 0; i<isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                ans++;
            }
        }
        return ans;
    }
}