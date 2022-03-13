class Solution {
    int m, n;
    char[][] grid;
    boolean[][] visited;
    
    int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    
    private boolean isValid(int i, int j){
        if(i >= 0 && i < m && j>=0 && j < n && !visited[i][j] && grid[i][j] == '1') return true;
        
        return false;
    }
    
    private void dfs(int i , int j){
        visited[i][j] = true;
        
        for(int[] dir: dirs){
            int newRow = i+dir[0];
            int newCol = j+dir[1];
            if(isValid(newRow, newCol))dfs(newRow, newCol);
        }
        
        return;
    }
    
    
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        
        int totalIslands = 0;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(isValid(i, j)){
                    dfs(i,j);
                    totalIslands++;
                }
            }
        }
        return totalIslands;
        
    }
}